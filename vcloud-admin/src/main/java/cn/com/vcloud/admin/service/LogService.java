package cn.com.vcloud.admin.service;

import java.util.List;

import cn.com.vcloud.admin.model.entity.SysLog;
import cn.com.vcloud.core.service.Service;

public interface LogService extends Service<SysLog>{

	/**
	 * 
	 * @Title: getLogList   
	 * @Description: 查询日志信息
	 * @param: @param page
	 * @return: List<SysLog>      
	 * @throws
	 */
	public List<SysLog> getLogList();
	
}
