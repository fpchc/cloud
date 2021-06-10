package com.pch.common.base;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @Author: pch
 * @Date: 2020-12-20 19:33
 */
@Getter
@Setter
@MappedSuperclass
@EntityListeners({ AuditingEntityListener.class })
public class BasePo implements Serializable {

    private static final long serialVersionUID = -6551747208670402225L;

    @Id
    @GeneratedValue(generator = "IdSnowflake")
    @GenericGenerator(name = "IdSnowflake", strategy = "com.pch.common.config.SnowFlakeIdGenerator")
    private Long id;

    @Version
    private Integer version;

    /**
     * 创建时间
     */
    @CreatedDate
    private LocalDateTime createdTime;

    /**
     * 更新时间
     */
    @LastModifiedDate
    private LocalDateTime updatedTime;

    /**
     * 创建人
     */
    @CreatedBy
    private String createdBy;

    /**
     * 更新人
     */
    @LastModifiedBy
    private String updatedBy;

}
