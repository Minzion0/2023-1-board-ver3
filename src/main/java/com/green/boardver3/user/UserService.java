package com.green.boardver3.user;

import com.green.boardver3.user.model.*;
import com.green.boardver3.utils.CommonUtils;
import org.apache.ibatis.binding.BindingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserMapper mapper;
    private final CommonUtils commonUtils;
    @Autowired
    public UserService(UserMapper mapper,CommonUtils commonUtils) {
        this.commonUtils = commonUtils;
        this.mapper = mapper;
    }

    public int insUser(UserInsDto dto){
        char gender = Character.toUpperCase(dto.getGender());
        if(!(gender == 'M' || gender=='F')){
            return -1;
        }
        dto.setGender(gender);
        String hpw = commonUtils.encodeSha256(dto.getUpw());
        dto.setUpw(hpw);
        try {
            return mapper.insUser(dto);

        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }

    }

    public int login(UserLoginDto dto){ //앞 보여주는거 안 입력받는거!

        UserLoginVo vo = mapper.sleUserById(dto);
        if (vo==null){
            return 2;
        }
        String pws = commonUtils.encodeSha256(dto.getUpw());
        if (!(vo.getUpw().equals(pws))){
           return 3;
       }
       return 1;





    }
    public int repUser(UserReDto dto){
        return mapper.repUser(dto);
    }
}
