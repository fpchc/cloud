package com.pch.eurekaclient.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pch.eurekaclient.domain.DeptDo;

@Repository
public interface DeptMapper extends BaseMapper<DeptDo> {

    List<DeptDo> findByUserId(Long userId);
}
