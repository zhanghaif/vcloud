package cn.com.vcloud.admin.core.interceptor;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.com.vcloud.admin.core.common.SysLog;
import cn.com.vcloud.admin.core.jwt.JwtUtil;
import cn.com.vcloud.admin.model.entity.SysUser;
import cn.com.vcloud.admin.service.LogService;
import cn.com.vcloud.admin.service.UserService;
import lombok.extern.slf4j.Slf4j;
/**
 * @className: LogInterceptor
 * @description: 配置日志拦截器
 * @author zhanghaifeng
 * @dateTime 2019年3月25日 11:40:40
 */
@Component
@Slf4j
public class LogInterceptor extends HandlerInterceptorAdapter {

    ThreadLocal<SysLog> logThreadLocal = new ThreadLocal<>();
    ThreadLocal<HttpSession> sessionThreadLocal = new ThreadLocal<>();
    ThreadLocal<SysUser> userThreadLocal = new ThreadLocal<>();

    @Resource
    LogService logService;
    
    @Resource
	UserService userService;
    
    @Resource
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
        	
            HandlerMethod hd = (HandlerMethod) handler;
            logThreadLocal.set(hd.getMethodAnnotation(SysLog.class));
            sessionThreadLocal.set(request.getSession());
            if (request.getSession() != null) {
            	userThreadLocal.set((SysUser) request.getSession().getAttribute("user"));
            }
        }
        return super.preHandle(request, response, handler);
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        try {
            SysLog sysLog = logThreadLocal.get();
            if (sysLog != null) {
                cn.com.vcloud.admin.model.entity.SysLog log = new cn.com.vcloud.admin.model.entity.SysLog();
                SysUser user = userThreadLocal.get();
                if (user == null && sessionThreadLocal.get() != null) {
                    user = (SysUser) user;
                }

                log.setModule(sysLog.module());
                log.setIp(getIpAddr(request));

                if (sysLog.params() != null && sysLog.params().length > 0) {
                    StringBuffer sb = new StringBuffer("[");
                    for (int i = 0; i < sysLog.params().length; i++) {
                        String key = sysLog.params()[i];
                        String value = request.getParameter(key);
                        sb.append(key).append(":").append(value);
                        sb.append(",");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append("]");

                    log.setAction(sysLog.action() + sb);
                } else {
                    log.setAction(sysLog.action());
                }

                if (ex != null) {
                    log.setException(ex.getMessage());
                }

                if (user != null) {
                    log.setUid(user.getId());
                }

                logService.save(log);
            }
        } catch (Exception e) {
            log.error("日志记录异常", e);
        }
    }

    private String getIpAddr(HttpServletRequest request) {
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inet.getHostAddress();
            }
        }
        if (ipAddress != null && ipAddress.length() > 15) {
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }
}
