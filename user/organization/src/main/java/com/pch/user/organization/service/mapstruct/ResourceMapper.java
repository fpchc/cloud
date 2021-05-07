package com.pch.user.organization.service.mapstruct;

import com.pch.user.organization.model.dto.ResourcesDto;
import com.pch.user.organization.model.po.ResourcePo;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @Author: pch
 * @Date: 2021/5/7 11:42
 */
@Mapper(componentModel = "spring")
public interface ResourceMapper {

    @InheritInverseConfiguration(name = "dtoToPo")
    ResourcesDto poToDto(ResourcePo resourcePo);

    ResourcePo dtoToPo(ResourcesDto resourcesDto);

}
