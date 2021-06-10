package com.pch.auth.authentication.model.dto;

import com.pch.common.base.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Author: pch
 * @Date: 2021/2/25
 */
@ApiModel("角色模型")
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class RoleDto extends BaseDto {

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
