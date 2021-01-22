package com.zwl.shop.service;

import com.zwl.shop.mbg.model.PmsBrand;

import java.util.List;

/**
 * @author zwl
 * @date : 2021/1/21 16:32
 */
public interface PmsBrandService {
    List<PmsBrand> listAllBrand();
    int createBrand(PmsBrand brand);
    int updateBrand(Long id, PmsBrand brand);
    int deleteBand(Long id);
    List<PmsBrand> listBrand(int pageNum, int pageSize);
    PmsBrand getBrandById(Long id);
}
