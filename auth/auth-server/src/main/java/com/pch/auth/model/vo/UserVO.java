package com.pch.auth.model.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.codehaus.jackson.map.Serializers.Base;

import com.pch.common.base.BaseDto;
import com.pch.common.base.BaseVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: pch
 * @Date: 2021/2/25
 */
@Data
@ApiModel("用户登录模型")
@EqualsAndHashCode(callSuper = true)
public class UserVO extends BaseVo {

    private static final long serialVersionUID = 2085570980822071154L;

    @NotBlank(message = "username is blank")
    @ApiModelProperty("登录用户名")
    private String username;

    @NotBlank(message = "username is blank")
    @ApiModelProperty("登录密码")
    private String password;
}
