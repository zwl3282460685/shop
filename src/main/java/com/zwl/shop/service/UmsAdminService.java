package com.zwl.shop.service;

import com.zwl.shop.mbg.model.UmsAdmin;
import com.zwl.shop.mbg.model.UmsPermission;

import java.util.List;

/**
 * 后台管理员Service
 * @author zwl
 * @data 2021/1/30 20:31
 **/
public interface UmsAdminService {
    /**
     * 根据用户名获取后台管理员
     */
    UmsAdmin getAdminByUserName(String username);

    /**
     *  注册功能
     */
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username, String password);

    /**
     * 根据用户id获取该用户的权限
     * @param adminId 用户id
     * @return 用户权限列表
     */
    List<UmsPermission> getPermissionList(Long adminId);

}
