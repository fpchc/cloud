package com.pch.gateway.event;

import java.io.Serializable;

import org.springframework.context.ApplicationEvent;

import com.pch.gateway.model.domain.UserPo;

/**
 * @Author: pch
 * @Date: 2020-12-19 20:38
 */
public class UserEvent extends ApplicationEvent implements Serializable {

    private UserPo userPo;

    private String action;

    public UserPo getUserDO() {
        return userPo;
    }

    public void setUserDO(UserPo userEvent) {
        this.userPo = userEvent;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public UserEvent(Object source, UserPo userPo, String action) {
        super(source);
        this.userPo = userPo;
        this.action = action;
    }
}
