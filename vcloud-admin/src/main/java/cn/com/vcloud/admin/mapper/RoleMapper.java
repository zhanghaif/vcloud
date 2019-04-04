package cn.com.vcloud.admin.mapper;

import java.util.List;

import cn.com.vcloud.admin.model.entity.SysRole;
import cn.com.vcloud.core.mapper.MyMapper;

public interface RoleMapper extends MyMapper<SysRole> {
    /**
     * 获取所有角色以及对应的权限
     *
     * @return 角色可控资源列表
     */
    List<SysRole> findAllRoleWithPermission();
}