package com.pch.gateway.event;

import java.io.Serializable;

import org.springframework.context.ApplicationEvent;

import com.pch.gateway.model.domain.UserPo;

/**
 * @Author: pch
 * @Date: 2020-12-19 20:38
 */
public class UserEvent extends ApplicationEvent implements Serializable {

    private static final long serialVersionUID = -5707310134577625463L;

    private UserPo userPo;

    public UserPo getUserDO() {
        return userPo;
    }

    public void setUserDO(UserPo userEvent) {
        this.userPo = userEvent;
    }

    public UserEvent(Object source, UserPo userPo) {
        super(source);
        this.userPo = userPo;
    }
}
