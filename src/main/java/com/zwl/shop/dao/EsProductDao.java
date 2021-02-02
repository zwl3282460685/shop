package com.zwl.shop.dao;

import com.zwl.shop.nosql.elasticsearch.document.EsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 搜索系统中的商品管理自定义Dao
 * @author zwl
 * @data 2021/1/31 20:09
 **/
public interface EsProductDao {
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
