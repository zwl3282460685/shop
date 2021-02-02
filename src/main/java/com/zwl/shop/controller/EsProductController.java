package com.zwl.shop.controller;

import com.zwl.shop.common.api.CommonPage;
import com.zwl.shop.common.api.CommonResult;
import com.zwl.shop.nosql.elasticsearch.document.EsProduct;
import com.zwl.shop.service.EsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 搜索商品管理Controller
 * @author zwl
 * @data 2021/1/31 20:19
 **/
@RestController
@Api(tags = "EsProductController", description = "搜索商品管理")
@RequestMapping("/esProduct")
public class EsProductController {

    @Autowired
    private EsProductService esProductService;

    @ApiOperation(value = "导入所有数据库中商品到ES")
    @PostMapping(value = "/importAll")
    public CommonResult<Integer> importAllList(){
        int count = esProductService.importAll();
        return CommonResult.success(count);
    }

    @ApiOperation(value = "根据id删除商品")
    @GetMapping("/delete/{id}")
    public CommonResult<Object> delete(@PathVariable Long id){
        esProductService.delete(id);
        return CommonResult.success(null);
    }

    @ApiOperation(value = "根据id批量删除商品")
    @PostMapping(value = "/delete/batch")
    public CommonResult<Object> delete(@RequestParam("ids")List<Long>ids){
        esProductService.delete(ids);
        return CommonResult.success(null);
    }

    @ApiOperation(value = "根据id创建商品")
    @PostMapping("/create/{id}")
    public CommonResult<EsProduct> create(@PathVariable Long id){
        EsProduct esProduct = esProductService.create(id);
        if(esProduct != null){
            return CommonResult.success(esProduct);
        }else{
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "简单搜索")
    @GetMapping("/search/simple")
    public CommonResult<CommonPage<EsProduct>> search(@RequestParam(required = false) String keyword,
                                                      @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                      @RequestParam(required = false, defaultValue = "5") Integer pageSize){
        Page<EsProduct> esProductPage = esProductService.search(keyword, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(esProductPage));
    }
}
