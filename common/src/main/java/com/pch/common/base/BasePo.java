package com.pch.common.base;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;

/**
 * @Author: pch
 * @Date: 2020-12-20 19:33
 */
@Data
public class BasePo implements Serializable {

    private static final long serialVersionUID = -6551747208670402225L;

    @TableId(type = IdType.ASSIGN_ID)
    protected Long id;

    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    @TableField(fill = FieldFill.INSERT)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    private String modifyBy;

    @TableField(fill = FieldFill.UPDATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifyTime;



}
