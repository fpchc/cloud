package com.pch.auth.authorization.model.dto;

import com.pch.common.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: pch
 * @Date: 2021/2/25
 */
@Getter
@Setter
@ApiModel("角色模型")
public class RoleDto extends BaseModel {

    private static final long serialVersionUID = 6820960471692554967L;

    private Long id;

    @ApiModelProperty("角色名称")
    private String name;

    @ApiModelProperty("角色code")
    private String code;

    @ApiModelProperty("角色描述")
    private String description;

    @ApiModelProperty(hidden = true)
    private String createBy;

    @ApiModelProperty(hidden = true)
    private String updatedBy;

    @ApiModelProperty(hidden = true)
    private LocalDateTime createTime;

    @ApiModelProperty(hidden = true)
    private LocalDateTime updateTime;
}
