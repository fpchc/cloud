package com.pch.gateway.event;

import org.springframework.context.ApplicationEvent;

import com.pch.gateway.model.domain.UserPo;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: pch
 * @Date: 2020-12-19 20:38
 */
public class UserEvent extends ApplicationEvent {

    private static final long serialVersionUID = -5707310134577625463L;

    @Getter
    @Setter
    private UserPo userPo;

    public UserPo getUserDO() {
        return userPo;
    }

    public UserEvent(Object source, UserPo userPo) {
        super(source);
        this.userPo = userPo;
    }
}
