package com.pch.eurekaclient.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class UserDto implements Serializable {

    private static final long serialVersionUID = 7763449128916101117L;

    private String username;

    private String email;

    private String telephone;

    private List<DeptDto> deptDtos;

}
