package com.wangyx.sell.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by 廖师兄
 * 2017-07-23 23:02
 */
@Data
@Entity
public class SellerInfo implements Serializable {

    private static final long serialVersionUID = -2950443496581493726L;
    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;
}
