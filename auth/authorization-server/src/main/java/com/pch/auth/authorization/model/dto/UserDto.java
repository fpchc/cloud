package com.pch.auth.authorization.model.dto;

import javax.validation.constraints.NotBlank;

import com.pch.common.base.BaseDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: pch
 * @Date: 2021/2/25
 */
@Data
@ApiModel("用户实体")
@EqualsAndHashCode(callSuper = true)
public class UserDto extends BaseDto {

    private static final long serialVersionUID = -1987138807436518343L;

    private Long id;

    @NotBlank(message = "username is blank")
    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    /**
     * 登录名称
     */
    @ApiModelProperty("登录名")
    private String loginName;

    /**
     * 密码
     */
    @NotBlank(message = "password is blank")
    @ApiModelProperty("密码")
    private String password;

    /**
     * tell
     */
    @ApiModelProperty("电话")
    private String telephone;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;

    /**
     * 状态
     */
    private Short status;

    /**
     * 启用禁用
     */
    @ApiModelProperty("状态 启用 禁用")
    private Boolean enable;

    /**
     * 更新人
     */
    @ApiModelProperty("更新者")
    private String updatedBy;

}
