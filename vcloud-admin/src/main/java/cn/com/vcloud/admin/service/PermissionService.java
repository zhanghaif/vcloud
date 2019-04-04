package cn.com.vcloud.admin.service;

import java.util.List;

import cn.com.vcloud.admin.model.entity.SysPermission;
import cn.com.vcloud.core.service.Service;

public interface PermissionService extends Service<SysPermission> {
    /**
     * 找到所有权限可控资源
     *
     */
	List<SysPermission> findAllResourcePermission();
}
