package cn.com.vcloud.admin.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.vcloud.admin.core.common.SysLog;
import cn.com.vcloud.admin.model.entity.SysPermission;
import cn.com.vcloud.admin.service.PermissionService;
import cn.com.vcloud.core.response.Result;
import cn.com.vcloud.core.response.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @className: PermissionController
 * @description: 权限管理类
 * @author zhanghaifeng
 * @dateTime 2019年3月20日 
 */
@Api(value="权限管理",tags={"权限管理"})
@RestController
@RequestMapping("/v1/system/permission")
@Validated
public class PermissionController {

	@Resource
	PermissionService permissionService;
	
	@PreAuthorize("hasAuthority('system:permission:list')")
	@ApiOperation(value = "获取所有菜单信息", notes = "菜单信息")
	@SysLog(module = "菜单", action = "列表")
	@GetMapping
	public Result list() {
		List<SysPermission> list = permissionService.findAllResourcePermission();
		
		return ResultGenerator.genOkResult(list);
	}
	
	
}
