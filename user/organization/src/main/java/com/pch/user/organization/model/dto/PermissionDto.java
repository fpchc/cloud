package com.pch.user.organization.model.dto;

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
@ApiModel("权限模型")
public class PermissionDto extends BaseModel {

    private static final long serialVersionUID = -9026406455401591586L;

    @ApiModelProperty("父id")
    private Integer pid;

    @ApiModelProperty("资源类型(1：菜单 2：按钮 3：操作)")
    private Integer type;

    @ApiModelProperty("资源名称")
    private String name;

    @ApiModelProperty("资源标识")
    private String code;

    @ApiModelProperty("资源url")
    private String uri;

    @ApiModelProperty("序号")
    private Integer seq = 1;

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
