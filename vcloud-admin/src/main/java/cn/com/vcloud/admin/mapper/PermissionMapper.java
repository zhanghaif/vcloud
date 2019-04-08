package cn.com.vcloud.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.alibaba.fastjson.JSONObject;

import cn.com.vcloud.admin.model.entity.SysPermission;
import cn.com.vcloud.core.mapper.MyMapper;

public interface PermissionMapper extends MyMapper<SysPermission> {
	/**
     * 权限列表
     *
     * @return
     */
	List<SysPermission> list();
    /**
     * 找到所有权限可控资源
     *
     * @return Json对象列表
     */
    List<JSONObject> findAllResourcePermission();

    /**
     * 获取所有权限代码
     *
     * @return 代码列表
     */
    @Select("SELECT p.code FROM `sys_permission` p")
    List<String> findAllCode();
}