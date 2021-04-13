package com.pch.common.base;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;

/**
 * @Author: pch
 * @Date: 2020-12-20 19:33
 */
@Getter
@Setter
@MappedSuperclass
public class BasePo implements Serializable {

    private static final long serialVersionUID = -6551747208670402225L;

    @Id
    @GeneratedValue(generator = "IdSnowflake")
    @GenericGenerator(name = "IdSnowflake", strategy = "com.pch.common.config.SnowFlakeIdGenerator")
    protected Long id;

    @Version
    protected Integer version;

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o, false);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, false);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
