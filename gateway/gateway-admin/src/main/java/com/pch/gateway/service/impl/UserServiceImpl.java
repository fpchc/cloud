package com.pch.gateway.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pch.gateway.mapper.UserMapper;
import com.pch.gateway.model.domain.UserPo;
import com.pch.gateway.service.UserService;

/**
 * <P> user 业务具体实现 </P>
 *
 * @Author: pch
 * @Date: 2020-12-20 14:12
 */
@Service
public class UserServiceImpl extends
        ServiceImpl<UserMapper, UserPo> implements UserService {

}
