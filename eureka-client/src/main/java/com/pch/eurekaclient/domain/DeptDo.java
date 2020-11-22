package com.pch.eurekaclient.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class DeptDo implements Serializable {

    private static final long serialVersionUID = -1606181164017081809L;

    private Long id;

    private String name;

}
