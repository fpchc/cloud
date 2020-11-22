package com.pch.eurekaclient.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pch.eurekaclient.domain.UserDo;

@Repository
public interface UserMapper extends BaseMapper<UserDo> {

    List<UserDo> findAll();
}
