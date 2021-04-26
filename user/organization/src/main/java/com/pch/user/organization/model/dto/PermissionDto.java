package com.pch.user.organization.model.dto;

import com.pch.common.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty("简介")
    private String description;

}
