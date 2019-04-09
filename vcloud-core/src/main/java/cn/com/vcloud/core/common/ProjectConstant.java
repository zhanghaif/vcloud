package cn.com.vcloud.core.common;

/**
 * @className: ProjectConstant
 * @description: 项目常量
 * @author zhanghaifeng
 * @dateTime 2019年3月18日 
 */
public final class ProjectConstant {
	
	/**
	 * Project项目基本结构包
	 */
    public static final String BASE_PACKAGE = "cn.com.vcloud";
    
    /**
     * Core核心类包
     */
    public static final String CORE_PACKAGE = BASE_PACKAGE + ".core";
    
    /**
     ** 权限管理模块基本结构包
     */
    public static final String ADMIN_BASE_PACKAGE = ".admin";
   
    /**
     ** 权限管理模块Mapper所在包
     */
    public static final String ADMIN_MAPPER_PACKAGE = BASE_PACKAGE + ".admin.mapper";
    
    /**
     ** 权限管理模块controller所在包
     */
    public static final String ADMIN_CONTROLLER_PACKAGE = BASE_PACKAGE + ".admin.controller";
    
    /**
     ** 示例代码管理模块基本结构包
     */
    public static final String TEST_BASE_PACKAGE = ".test";
   
    /**
     ** 示例代码管理模块Mapper所在包
     */
    public static final String TEST_MAPPER_PACKAGE = BASE_PACKAGE + ".test.mapper";
    
   
}
