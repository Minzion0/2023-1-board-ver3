package com.green.boardver3.user;

import com.green.boardver3.user.model.*;
import com.green.boardver3.utils.CommonUtils;
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

        UserLoginVo vo = mapper.selUserById(dto);
        String pws = commonUtils.encodeSha256(dto.getUpw());
        if (vo==null){
            return 2;
        }
        if (vo.getUpw().equals(pws)){
           return 1;
       }
       return 3;





    }
    public int repUser(UserReDto dto){
        String npw = commonUtils.encodeSha256(dto.getNpw());
        dto.setNpw(npw);
        return mapper.repUser(dto);
    }
}
