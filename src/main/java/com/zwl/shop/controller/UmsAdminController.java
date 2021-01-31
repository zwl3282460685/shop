package com.zwl.shop.controller;

import com.zwl.shop.common.api.CommonResult;
import com.zwl.shop.dto.UmsAdminLoginParam;
import com.zwl.shop.mbg.model.UmsAdmin;
import com.zwl.shop.mbg.model.UmsPermission;
import com.zwl.shop.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台用户管理
 * @author zwl
 * @data 2021/1/31 10:03
 **/
@RestController
@RequestMapping("/admin")
@Api(tags = "UmsAdminController", description = "后台用户管理接口")
public class UmsAdminController {
    @Autowired
    private UmsAdminService umsAdminService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/register")
    public CommonResult<UmsAdmin> register(@RequestBody UmsAdmin umsAdminParam){
        UmsAdmin umsAdmin = umsAdminService.register(umsAdminParam);
        if(null == umsAdmin){
            CommonResult.failed("该用户已被注册！");
        }
        return CommonResult.success(umsAdmin,"用户注册成功");
    }

    @ApiOperation(value = "登录后返回token")
    @PostMapping("/login")
    public CommonResult login(UmsAdminLoginParam umsAdminLoginParam, BindingResult result){
        String token = umsAdminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if(token == null){
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @GetMapping("/permission/{adminId}")
    @ApiOperation(value = "获取用户所有权限（包括+-权限")
    public CommonResult<List<UmsPermission>> getPermissionList(@PathVariable Long adminId){
        List<UmsPermission> permissionList = umsAdminService.getPermissionList(adminId);
        return CommonResult.success(permissionList);
    }
}
