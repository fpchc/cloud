package com.pch.auth.authorization.model.dto;

import java.time.LocalDateTime;

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
@EqualsAndHashCode(callSuper = true)
@ApiModel("角色模型")
public class RoleDto extends BaseDto {

    private static final long serialVersionUID = 6820960471692554967L;

    private Long id;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("角色code")
    private String roleCode;

    @ApiModelProperty("角色描述")
    private String roleDescription;

    @ApiModelProperty(hidden = true)
    private String createBy;

    /**
     * 更新人
     */
    @ApiModelProperty(hidden = true)
    private String updatedBy;

    /**
     * 创建时间
     */
    @ApiModelProperty(hidden = true)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(hidden = true)
    private LocalDateTime updateTime;
}
