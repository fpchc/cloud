package com.pch.eurekaclient.domain;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("tb_user")
public class UserDo implements Serializable {

    private static final long serialVersionUID = -2378122303549539078L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String username;

    private String password;

    private String email;

    private String telephone;

    private List<DeptDo> deptDos;

}
