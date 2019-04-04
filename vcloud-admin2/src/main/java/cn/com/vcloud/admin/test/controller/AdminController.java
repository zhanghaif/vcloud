package cn.com.vcloud.admin.test.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.com.vcloud.core.response.Result;
import cn.com.vcloud.core.response.ResultGenerator;

/**
 * @className: AdminController
 * @description: 登录类
 * @author zhanghaifeng
 * @dateTime 2019年3月19日 
 */
@RestController
@RequestMapping("/v2")
@Validated
public class AdminController {
	
    @GetMapping("/info")
    public Result get() {
        return ResultGenerator.genOkResult("12321");
    }
	
	

}
