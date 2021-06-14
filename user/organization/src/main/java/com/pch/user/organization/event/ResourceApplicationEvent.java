package com.pch.user.organization.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * @Author: pch
 * @Date: 2021/6/12 18:44
 */
public class ResourceApplicationEvent extends ApplicationEvent {

    @Getter
    @Setter
    private String action;

    public ResourceApplicationEvent(Object source, String action) {
        super(source);
        this.action = action;
    }
}
