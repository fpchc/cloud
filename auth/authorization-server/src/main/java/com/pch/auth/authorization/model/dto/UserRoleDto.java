package com.pch.auth.authorization.model.dto;

import com.pch.common.base.BaseDto;
import io.swagger.annotations.ApiModel;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author: pch
 * @Date: 2021/2/25
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@ApiModel("用户角色模型")
public class UserRoleDto extends BaseDto {

    private static final long serialVersionUID = 6477164357249393295L;

    @NotNull(message = "userId is null")
    private Long userId;

    @NotNull(message = "roleIds is null")
    private List<Long> roleIds;
}
