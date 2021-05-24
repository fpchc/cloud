package com.pch.user.organization.model.query;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Author: pch
 * @Date: 2021/5/21 11:01
 */
@Data
@ToString(callSuper = true)
public class ResourcePage {

    private static final long serialVersionUID = -763948377514408493L;

    @ApiModelProperty("代码")
    @NotBlank(message = "code is blank, please checked")
    @Size(max = 30)
    private String code;

    @ApiModelProperty("类型")
    @Size(max = 30)
    @NotBlank(message = "type is blank, please checked")
    private String type;

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
}
