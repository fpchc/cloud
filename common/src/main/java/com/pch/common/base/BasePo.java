package com.pch.common.base;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * @Author: pch
 * @Date: 2020-12-20 19:33
 */
@Data
@MappedSuperclass
public class BasePo implements Serializable {

    private static final long serialVersionUID = -6551747208670402225L;

    @Id
    @GeneratedValue(generator = "IdSnowflake")
    @GenericGenerator(name = "IdSnowflake", strategy = "com.pch.common.config.SnowFlakeIdGenerator")
    protected Long id;

    @Version
    protected Integer version;

}
