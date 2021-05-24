package com.pch.auth.authorization.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pch.auth.authorization.model.po.UserPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: pch
 * @Date: 2021/2/23
 */
@Mapper
public interface UserMapper extends BaseMapper<UserPo> {

    UserPo findByUsername(String username);
}
