package com.pch.eurekaclient.service;

import java.util.List;

import com.pch.eurekaclient.domain.UserDo;

public interface UserService {

    List<UserDo> findAll();
}
