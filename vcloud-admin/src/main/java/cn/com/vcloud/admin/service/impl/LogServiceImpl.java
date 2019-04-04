package cn.com.vcloud.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.vcloud.admin.mapper.LogMapper;
import cn.com.vcloud.admin.model.entity.SysLog;
import cn.com.vcloud.admin.service.LogService;
import cn.com.vcloud.core.service.AbstractService;
import lombok.AllArgsConstructor;
/**
 * @className: LogServiceImpl
 * @description: 日志service
 * @author zhanghaifeng
 * @dateTime 2019年3月25日 09:34:21
 */

@Service
@AllArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class LogServiceImpl extends AbstractService<SysLog> implements LogService{

	@Resource
    LogMapper logMapper;

    public List<SysLog> getLogList() {
    	
        return logMapper.getLogs();
    }
}
