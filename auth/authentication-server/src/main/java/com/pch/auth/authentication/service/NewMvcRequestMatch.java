package com.pch.auth.authentication.service;

import lombok.Getter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

/**
 * @Author: pch
 * @Date: 2021/5/6 15:23
 */
@Getter
public class NewMvcRequestMatch extends MvcRequestMatcher {

    private String pattern;

    private String method;

    public NewMvcRequestMatch(HandlerMappingIntrospector introspector,
            String pattern, String method) {
        super(introspector, pattern);
        this.method = method;
        this.pattern = pattern;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NewMvcRequestMatch that = (NewMvcRequestMatch) o;

        return new EqualsBuilder().append(pattern, that.pattern)
                .append(method, that.method).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(pattern).append(method).toHashCode();
    }
}
