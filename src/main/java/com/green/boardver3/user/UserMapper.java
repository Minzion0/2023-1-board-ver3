package com.green.boardver3.user;

import com.green.boardver3.user.model.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserInsDto dto);
    UserSelVo selUser(UserSelDto dto);//앞에께 보여주는거 ()께 입력하는거
    int repUser(UserReDto dto);
    int updUser(Filepic pic);
}
