package com.pch.common.base;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 * @Author: pch
 * @Date: 2020-12-20 19:33
 */
@Getter
@Setter
@MappedSuperclass
public class BasePo extends BaseModel {

    private static final long serialVersionUID = -6551747208670402225L;

    @Id
    @GeneratedValue(generator = "IdSnowflake")
    @GenericGenerator(name = "IdSnowflake", strategy = "com.pch.common.config.SnowFlakeIdGenerator")
    private Long id;

    @Version
    private Integer version;

}
