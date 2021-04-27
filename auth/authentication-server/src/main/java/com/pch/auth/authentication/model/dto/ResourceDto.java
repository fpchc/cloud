package com.pch.auth.authentication.model.dto;

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
public class ResourceDto extends BaseModel {

    private static final long serialVersionUID = -9026406455401591586L;

    @ApiModelProperty("代码")
    private String code;

    @ApiModelProperty("类型")
    private Integer type;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("url")
    private String url;

    @ApiModelProperty("方法")
    private String method;

    @ApiModelProperty("描述")
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
