package com.green.boardver3.user;

import com.green.boardver3.board.BoardService;
import com.green.boardver3.board.model.BoardDelDto;
import com.green.boardver3.cmt.model.CmtDelDto;
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
    private final BoardService service;


    @Value("${file.dir}")
    private String fileDir;

    @Autowired
    public UserService(UserMapper mapper,CommonUtils commonUtils,BoardService service) {
        this.commonUtils = commonUtils;
        this.mapper = mapper;
        this.service = service;
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
    public int updUserPic(UserMainPicDto userMainPicDto, MultipartFile pic){
        String dicPath = String.format("%s/user/%d",fileDir,userMainPicDto.getIuser());

        File dic = new File(dicPath);
        if (!dic.exists()){
            dic.mkdirs();// 폴더 생성
        }
        String saveFileName = FileUtils.makeRandomFileNm(pic.getOriginalFilename());
//        String originalFilename = pic.getOriginalFilename();
//        String uuid = UUID.randomUUID().toString();
//        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
//
//        String saveFileName = uuid + ext;
        String savePath = dicPath + "/" + saveFileName;
        File file = new File(savePath);

        try {
            userMainPicDto.setMainPic(saveFileName);
            pic.transferTo(file);
            return mapper.updUserPic(userMainPicDto);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return 0;
    }
    public int userDel(UserAllDelDto dto){
        BoardDelDto boardDelDto = new BoardDelDto();
        boardDelDto.setIuser(dto.getIuser());
        int i = service.deleBoard(boardDelDto);
        if (i==1){
          return mapper.userDel(dto);
        }

        return 0;
    }
}