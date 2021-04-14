package com.pch.auth.authorization.oauth2;

import com.pch.auth.authorization.model.po.UserPo;
import com.pch.auth.authorization.service.UserService;
import com.pch.common.exception.ServiceException;
import java.util.Optional;
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
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String uniqueId) {

        Optional<UserPo> userPo = userService.loadByUsername(uniqueId);
//        log.info("load user by mobile:{}", user.toString());

        // 如果为mobile模式，从短信服务中获取验证码（动态密码）
//        String credentials = smsCodeProvider.getSmsCode(uniqueId, "LOGIN");
        if (userPo.isEmpty()) {
            throw new ServiceException("", "");
        }
        UserPo user = userPo.get();
        return new User(user.getUsername(), user.getPassword(), null);
    }
}
