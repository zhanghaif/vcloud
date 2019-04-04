package cn.com.vcloud.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.vcloud.admin.mapper.RoleMapper;
import cn.com.vcloud.admin.model.entity.SysRole;
import cn.com.vcloud.admin.service.RoleService;
import cn.com.vcloud.core.service.AbstractService;

/**
 * @className: RoleServiceImpl
 * @description: 角色service
 * @author zhanghaifeng
 * @dateTime 2019年3月21日 
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl extends AbstractService<SysRole> implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<SysRole> findAllRoleWithPermission() {
        return this.roleMapper.findAllRoleWithPermission();
    }

}
