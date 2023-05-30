package com.green.boardver3.user;

import com.green.boardver3.user.model.UserInsDto;
import com.green.boardver3.user.model.UserInsVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserInsDto dto);
    UserInsVo selUser(UserInsVo vo);
}
