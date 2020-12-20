package com.pch.gateway.model.domain;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * <p> 用户实体 </p>
 *
 * @Author: pch
 * @Date: 2020/12/15 15:58
 */
@Data
@TableName("tb_user")
public class UserPo implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private String telephone;

}

