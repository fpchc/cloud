package com.pch.auth.authorization.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pch.auth.authorization.model.po.RolePo;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
public interface RoleDao extends BaseMapper<RolePo> {

    @Select("select tr.* from tb_role tr "
            + "inner join tb_user_role tur on tur.role_id = tr.id "
            + "where tur.user_id = #{userId}")
    List<RolePo> findByUserId(@Param("userId") Long userId);

}
