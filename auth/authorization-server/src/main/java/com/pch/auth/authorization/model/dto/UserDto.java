package com.pch.auth.authorization.model.dto;

import com.pch.common.base.BaseDto;
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
@ApiModel("用户实体")
public class UserDto extends BaseDto {

    private static final long serialVersionUID = -1987138807436518343L;

    private Long id;

    @NotBlank(message = "username is blank")
    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @ApiModelProperty("登录名")
    private String loginName;

    @NotBlank(message = "password is blank")
    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("电话")
    private String telephone;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("账户是否启用 true 没有过期")
    private Boolean accountNonExpired;

    @ApiModelProperty("账户是否锁定 true 没有所的那个")
    private Boolean accountNonLocked;

    @ApiModelProperty("状态 启用 禁用")
    private Boolean enable;

    @ApiModelProperty("更新者")
    private String updatedBy;

}
