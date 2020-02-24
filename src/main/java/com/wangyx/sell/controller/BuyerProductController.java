package com.wangyx.sell.controller;

import com.wangyx.sell.VO.ProductInfoVo;
import com.wangyx.sell.VO.ProductVo;
import com.wangyx.sell.VO.ResultVo;
import com.wangyx.sell.entity.ProductCategoryEntity;
import com.wangyx.sell.entity.ProductInfoEntity;
import com.wangyx.sell.service.ProductCategoryService;
import com.wangyx.sell.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @Author xxxx
 * @Date 2020/2/23 14:34
 * @Version 1.0
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService categoryService;

    @GetMapping("/list")
    public ResultVo list(){
        //1.查询所有上架商品
        List<ProductInfoEntity> upAll = productService.findUpAll();
        //2.查询类目（一次性查询）
        //从上架商品中查询
        List<Integer> categoryTypeList = upAll.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategoryEntity> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        //3.数据拼装
        List<ProductVo> productVoList = new ArrayList<>();
        for (ProductCategoryEntity productCategoryEntity:categoryList){
            ProductVo productVo = new ProductVo();
            productVo.setCategoryType(productCategoryEntity.getCategoryType());
            productVo.setCategoryName(productCategoryEntity.getCategoryName());
            List<ProductInfoVo> productInfoVoList = new ArrayList<>();
            for (ProductInfoEntity productInfo : upAll){
                if (productCategoryEntity.getCategoryType() == productInfo.getCategoryType()){
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo,productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            }
            productVo.setProductInfoVoList(productInfoVoList);
            productVoList.add(productVo);
        }
        ResultVo resultVo = new ResultVo();

        resultVo.setData(productVoList);
        resultVo.setCode(0);
        resultVo.setMsg("成功");

        return resultVo;
    }
}
