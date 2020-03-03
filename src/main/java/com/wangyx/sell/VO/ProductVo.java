package com.wangyx.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品（包含类目）
 * @Author xxxx
 * @Date 2020/2/23 15:37
 * @Version 1.0
 */
@Data
public class ProductVo implements Serializable {


    private static final long serialVersionUID = 3443100650261114610L;
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVo> productInfoVoList;
}
