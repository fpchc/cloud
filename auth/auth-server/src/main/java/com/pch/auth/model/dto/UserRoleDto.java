package com.pch.auth.model.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.w3c.dom.stylesheets.LinkStyle;

import com.pch.common.base.BaseDto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: pch
 * @Date: 2021/2/25
 */
@Data
@ApiModel("用户角色模型")
@EqualsAndHashCode(callSuper = true)
public class UserRoleDto extends BaseDto {

    private static final long serialVersionUID = 6477164357249393295L;

    @NotNull(message = "userId is null")
    private Long userId;

    @NotNull(message = "roleIds is null")
    private List<Long> roleIds;
}
