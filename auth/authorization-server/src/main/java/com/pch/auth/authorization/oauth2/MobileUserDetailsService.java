package com.pch.auth.authorization.oauth2;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pch.auth.authorization.mapper.UserMapper;
import com.pch.auth.authorization.model.po.UserPo;
import com.pch.common.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * 手机验证码登陆, 用户相关获取
 */
@Slf4j
@Service("mobileUserDetailsService")
public class MobileUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String uniqueId) {

        UserPo userPo = userMapper.selectOne(new QueryWrapper<UserPo>().eq("username", uniqueId));
//        log.info("load user by mobile:{}", user.toString());

        // 如果为mobile模式，从短信服务中获取验证码（动态密码）
//        String credentials = smsCodeProvider.getSmsCode(uniqueId, "LOGIN");
        if (null == userPo) {
            throw new ServiceException("", "");
        }
        return new User(userPo.getUsername(), userPo.getPassword(), null);
    }
}
