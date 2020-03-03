package com.wangyx.sell.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * http请求返回的最外层对象
 * @Author xxxx
 * @Date 2020/2/23 14:37
 * @Version 1.0
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVo<T> implements Serializable {

    private static final long serialVersionUID = -8357744984443663570L;
    /**错误码*/
    private Integer code;
    /** 提示信息 */
    private String msg;
    /** 具体内容 */
    private T data;

}
