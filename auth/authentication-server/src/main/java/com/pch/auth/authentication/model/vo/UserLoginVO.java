package com.pch.auth.authentication.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author: pch
 * @Date: 2021/2/25
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@ApiModel("用户登录模型")
public class UserLoginVO implements Serializable {

    private static final long serialVersionUID = 2085570980822071154L;

    @NotBlank(message = "username is blank")
    @ApiModelProperty("登录用户名")
    private String username;

    @NotBlank(message = "username is blank")
    @ApiModelProperty("登录密码")
    private String password;
}
