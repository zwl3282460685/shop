package com.zwl.shop.controller;

import com.zwl.shop.common.api.CommonPage;
import com.zwl.shop.common.api.CommonResult;
import com.zwl.shop.mbg.model.PmsBrand;
import com.zwl.shop.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 品牌管理Controller
 * @author zwl
 * @date : 2021/1/21 16:29
 */
@Api(tags = "PmsBrandController", description = "商品品牌管理接口")
@RestController
@RequestMapping("/brand")
public class PmsBrandController {
    @Autowired
    private PmsBrandService pmsBrandService;

    private static final org.slf4j.Logger LOGGER =  LoggerFactory.getLogger(PmsBrandController.class);

    @ApiOperation("获取所有品牌列表")
    @GetMapping("/listAll")
    public CommonResult<List<PmsBrand>> getBrandList() {
        return CommonResult.success(pmsBrandService.listAllBrand());
    }

    @ApiOperation("添加品牌")
    @PostMapping("/add")
    public CommonResult addBrand(@RequestBody PmsBrand pmsBrand){
        CommonResult commonResult;
        if(pmsBrandService.createBrand(pmsBrand) != 0){
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.debug("createBrand success:{}", pmsBrand);
        }else{
            commonResult = CommonResult.failed("添加品牌失败！");
            LOGGER.debug("createBrand failed:{}", pmsBrand);
        }
        return commonResult;
    }

    @ApiOperation("更新指定id品牌的信息")
    @PutMapping("/update/{id}")
    public CommonResult updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrand){
        CommonResult commonResult;
        if(pmsBrandService.updateBrand(id, pmsBrand) != 0){
            commonResult = CommonResult.success(pmsBrand, "更新成功");
            LOGGER.debug("updateBrand success:{}", pmsBrand);
        }else{
            commonResult = CommonResult.failed("品牌更新失败！");
            LOGGER.debug("updateBrand failed:{}", pmsBrand);
        }
        return commonResult;
    }

    @ApiOperation("删除指定id的品牌")
    @DeleteMapping("/delBrand/{id}")
    public CommonResult deleteBrand(@PathVariable("id") Long id){
        CommonResult commonResult;
        if(pmsBrandService.deleteBand(id) != 0){
            commonResult = CommonResult.success("品牌删除成功！");
            LOGGER.debug("updateBrand success :id{}", id);
        }else{
            commonResult = CommonResult.failed("品牌删除失败！");
            LOGGER.debug("updateBrand failed :id{}", id);
        }
        return commonResult;
    }


    @ApiOperation("分页查询品牌列表")
    @GetMapping("/list")
    public CommonResult<CommonPage<PmsBrand>> pageBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize){
        List<PmsBrand> brandList = pmsBrandService.listBrand(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }

    @ApiOperation("获取指定id的品牌详情")
    @GetMapping("/{id}")
    public CommonResult<PmsBrand> brand(@PathVariable("id") Long id){
        return CommonResult.success(pmsBrandService.getBrandById(id));
    }
}
