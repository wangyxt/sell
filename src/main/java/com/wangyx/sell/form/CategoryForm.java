package com.wangyx.sell.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by 廖师兄
 * 2017-07-23 21:43
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    /** 类目名字. */
    @NotEmpty(message = "类目名字必填")
    private String categoryName;

    /** 类目编号. */
    @NotNull(message = "类目编号必填")
    private Integer categoryType;
}
