package cn.com.vcloud.admin.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.vcloud.admin.mapper.PermissionMapper;
import cn.com.vcloud.admin.model.entity.SysPermission;
import cn.com.vcloud.admin.service.PermissionService;
import cn.com.vcloud.core.service.AbstractService;

/**
 * @className: PermissionServiceImpl
 * @description: 权限service
 * @author zhanghaifeng
 * @dateTime 2019年3月21日 
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class PermissionServiceImpl extends AbstractService<SysPermission> implements PermissionService {
    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<SysPermission> findAllResourcePermission() {
    	List<SysPermission> permissionList = permissionMapper.list();
        return buildPermissionTree(permissionList);
    }
  
    /**
     * 
     * @Title: buildPermissionTree   
     * @Description: 格式化菜单目录树
     * @param: @param permissionList
     * @param: @return      
     * @return: List<PermissionEntity>      
     * @throws
     */
    private List<SysPermission> buildPermissionTree(List<SysPermission> permissionList) {
    	List<SysPermission> nodeTrees = new ArrayList<SysPermission>();
        Map<String,SysPermission> treeMap = new LinkedHashMap<String,SysPermission>();
        for(SysPermission node : permissionList){
        	SysPermission treeNode = new SysPermission();
            treeNode.setId(node.getId());
            treeNode.setCode(node.getCode());
            treeNode.setHandle(node.getHandle());
            treeNode.setName(node.getName());
            treeNode.setParentId(node.getParentId());
            treeNode.setResource(node.getResource());
            treeMap.put(node.getId().toString(), treeNode);
        }
        for(String nodeId : treeMap.keySet()){
        	SysPermission treeNode = treeMap.get(nodeId);
            Long pid = treeNode.getParentId();
            if(pid==null  || !treeMap.containsKey(pid.toString())){
                treeNode.setParentId(null);
                nodeTrees.add(treeNode);
            }else{
            	SysPermission parentTreeNode = treeMap.get(pid.toString());
                if(parentTreeNode.getChildren()==null){
                    parentTreeNode.setChildren(new ArrayList<SysPermission>());
                }
                parentTreeNode.getChildren().add(treeNode);
            }
        }
        return nodeTrees;
    }
}
