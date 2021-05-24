package com.pch.user.organization.service.mapstruct;

import com.pch.user.organization.model.dto.ResourceDto;
import com.pch.user.organization.model.po.ResourcePo;
import java.util.List;
import org.mapstruct.Mapper;

/**
 * @Author: pch
 * @Date: 2021/5/7 11:42
 */
@Mapper
public interface ResourceMapper {

    ResourceDto poToDto(ResourcePo resourcePo);

    List<ResourceDto> poToDtoList(List<ResourcePo> resourcePoList);

    ResourcePo dtoToPo(ResourceDto resourceDto);

}
