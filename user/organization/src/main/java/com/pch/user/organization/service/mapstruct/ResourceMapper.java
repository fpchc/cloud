package com.pch.user.organization.service.mapstruct;

import com.pch.user.organization.model.dto.ResourcesDto;
import com.pch.user.organization.model.po.ResourcePo;
import java.util.List;
import org.mapstruct.Mapper;

/**
 * @Author: pch
 * @Date: 2021/5/7 11:42
 */
@Mapper
public interface ResourceMapper {

    ResourcesDto poToDto(ResourcePo resourcePo);

    List<ResourcesDto> poToDtoList(List<ResourcePo> resourcePoList);

    ResourcePo dtoToPo(ResourcesDto resourcesDto);

}
