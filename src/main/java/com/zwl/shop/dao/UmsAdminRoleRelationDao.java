package com.zwl.shop.dao;

import com.zwl.shop.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户与角色管理自定义Dao
 * @author zwl
 * @data 2021/1/30 20:59
 **/
@Mapper
public interface UmsAdminRoleRelationDao {
    //获取用户所有权限(包括+-权限)
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
