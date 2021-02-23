package com.pch.common.base;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: pch
 * @Date: 2020-12-20 19:33
 */
@Getter
@Setter
public class BasePo implements Serializable {

    private static final long serialVersionUID = -6551747208670402225L;

    @Id
    @GeneratedValue(generator = "IdSnowflake")
    @GenericGenerator(name = "IdSnowflake", strategy = "com.pch.common.config.HibernateIdGenerator")
    protected Long id;

}
