package com.wangyx.sell.VO;

import lombok.Data;

/**
 * http请求返回的最外层对象
 * @Author xxxx
 * @Date 2020/2/23 14:37
 * @Version 1.0
 */
@Data
public class ResultVo<T> {

    /**错误码*/
    private Integer code;
    /** 提示信息 */
    private String msg;
    /** 具体内容 */
    private T data;

}
