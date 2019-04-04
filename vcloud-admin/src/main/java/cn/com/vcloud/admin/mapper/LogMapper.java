package cn.com.vcloud.admin.mapper;

import java.util.List;

import cn.com.vcloud.admin.model.entity.SysLog;
import cn.com.vcloud.core.mapper.MyMapper;

public interface LogMapper extends MyMapper<SysLog> {

    /**
     * 获取日志列表
     *
     * @return
     */
    List<SysLog> getLogs();

    /**
     * 插入日志
     *
     * @param sysLog
     * @return
     */
//    int insert(SysLog sysLog);
}
