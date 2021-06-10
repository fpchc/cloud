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
@Data
@ApiModel("权限模型")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ResourceDto extends BaseDto {

    private static final long serialVersionUID = -9026406455401591586L;

    private Long id;

    @ApiModelProperty("代码")
    private String code;

    @ApiModelProperty("类型")
    private String type;

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
