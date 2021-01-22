package com.zwl.shop.service;

/**
 * @author zwl
 * redis操作Service,
 * 对象和数组都以json形式进行存储
 * @date : 2021/1/22 16:24
 */
public interface RedisService {
    //存储数据
    void set(String key, String value);

    //获取数据
    String get(String key);

    //设置超时时间
    boolean expire(String key, long expire);

    //删除key
    void remove(String key);

    /**
     * 自增操作
     * @param key 对应的key
     * @param delta 自增步长
     */
    Long increment(String key, long delta);
}
