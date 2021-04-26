package com.pch.user.organization.model.vo;

import com.pch.common.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: pch
 * @Date: 2021/2/25
 */
@Getter
@Setter
@ApiModel("用户登录模型")
public class UserLoginVO extends BaseModel {

    private static final long serialVersionUID = 2085570980822071154L;

    @NotBlank(message = "username is blank")
    @ApiModelProperty("登录用户名")
    private String username;

    @NotBlank(message = "username is blank")
    @ApiModelProperty("登录密码")
    private String password;
}
