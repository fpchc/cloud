package com.pch.user.organization.model.dto;

import com.pch.common.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: pch
 * @Date: 2021/2/25
 */
@Getter
@Setter
@ApiModel("资源模型")
public class ResourcesDto extends BaseModel {

    private static final long serialVersionUID = -9026406455401591586L;

    private Long id;

    @ApiModelProperty("代码")
    @NotBlank(message = "code is blank, please checked")
    @Size(max = 30)
    private String code;

    @ApiModelProperty("类型")
    @Size(max = 30)
    @NotBlank(message = "type is blank, please checked")
    private Integer type;

    @ApiModelProperty("名称")
    @Size(max = 30)
    @NotBlank(message = "name is blank, please checked")
    private String name;

    @ApiModelProperty("url")
    @Size(max = 30)
    @NotBlank(message = "url is blank, please checked")
    private String url;

    @ApiModelProperty("方法")
    @Size(max = 30)
    @NotBlank(message = "method is blank, please checked")
    private String method;

    @ApiModelProperty("简介")
    private String description;

}
