package com.green.boardver3.user;

import com.green.boardver3.user.model.*;
import com.green.boardver3.utils.CommonUtils;
import com.green.boardver3.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Service
public class UserService {
    private final UserMapper mapper;
    private final CommonUtils commonUtils;


    @Value("${file.dir}")
    private String fileDir;

    @Autowired
    public UserService(UserMapper mapper, CommonUtils commonUtils) {
        this.commonUtils = commonUtils;
        this.mapper = mapper;
    }

    public int insUser(UserInsDto dto) {
        char gender = Character.toUpperCase(dto.getGender());
        if (!(gender == 'M' || gender == 'F')) {
            return -1;
        }
        dto.setGender(gender);
        String hpw = commonUtils.encodeSha256(dto.getUpw());
        dto.setUpw(hpw);
        try {
            return mapper.insUser(dto);

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public int login(UserLoginDto dto) { //앞 보여주는거 안 입력받는거!

        UserLoginVo vo = mapper.selUserById(dto);
        String pws = commonUtils.encodeSha256(dto.getUpw());
        if (vo == null) {
            return 2;
        }
        if (vo.getUpw().equals(pws)) {
            return 1;
        }
        return 3;


    }

    public int repUser(UserReDto dto) {
        String npw = commonUtils.encodeSha256(dto.getNpw());
        dto.setNpw(npw);
        return mapper.repUser(dto);
    }

    public int updUserPic(UserMainPicDto userMainPicDto, MultipartFile pic) {
        String centerPath = String.format("user/%d", userMainPicDto.getIuser());
        String dicPath = String.format("%s/%s", fileDir, centerPath);

        File dic = new File(dicPath);
        if (!dic.exists()) {
            dic.mkdirs();// 폴더 생성
        }


        String saveFileName = FileUtils.makeRandomFileNm(pic.getOriginalFilename());


        String saveFilePath = dicPath + saveFileName;
        File file = new File(saveFilePath);

        try {
            pic.transferTo(file);

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        userMainPicDto.setMainPic(centerPath + saveFileName);
        try {
            int result = mapper.updUserPic(userMainPicDto);
            if (result == 0) {
                throw new Exception("프로필사진 등록할수없습니다");
            }
        }catch (Exception e){
            file.delete();
            return 0;
        }
        return 1;
    }
}