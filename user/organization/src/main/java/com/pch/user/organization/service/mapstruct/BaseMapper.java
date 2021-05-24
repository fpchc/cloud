package com.pch.user.organization.service.mapstruct;

import java.util.List;

/**
 * @Author: pch
 * @Date: 2021/5/18 18:00
 */
public interface BaseMapper<S, T> {

    T sourceToTarget(S source);

    List<T> sourceToTarget(List<S> source);

    S targetToSource(T target);

    List<S> targetToSource(List<T> target);
}
