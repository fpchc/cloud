package com.pch.eurekaclient.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class DeptDto implements Serializable {

    private static final long serialVersionUID = 6965566422570764770L;

    private Long id;

    private String name;
}
