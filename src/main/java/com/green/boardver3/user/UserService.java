package com.green.boardver3.user;

import com.green.boardver3.user.model.UserInsDto;
import com.green.boardver3.user.model.UserReDto;
import com.green.boardver3.user.model.UserSelDto;
import com.green.boardver3.user.model.UserSelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserMapper mapper;
    @Autowired
    public UserService(UserMapper mapper) {
        this.mapper = mapper;
    }

    public int insUser(UserInsDto dto){
        return mapper.insUser(dto);
    }

    public UserSelVo selUser(UserSelDto dto){ //앞 보여주는거 안 입력받는거!
        return mapper.selUser(dto);
    }
    public int repUser(UserReDto dto){
        return mapper.repUser(dto);
    }
}
