package com.green.boardver3.user;

import com.green.boardver3.user.model.UserInsDto;
import com.green.boardver3.user.model.UserReDto;
import com.green.boardver3.user.model.UserLoninDto;
import com.green.boardver3.user.model.UserSelVo;
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

    public UserSelVo selUser(UserLoninDto dto){ //앞 보여주는거 안 입력받는거!
        String hpw = commonUtils.encodeSha256(dto.getUpw());
        dto.setUpw(hpw);
        return mapper.selUser(dto);
    }
    public int repUser(UserReDto dto){
        return mapper.repUser(dto);
    }
}
