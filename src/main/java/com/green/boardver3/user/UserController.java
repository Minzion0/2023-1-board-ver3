package com.green.boardver3.user;

import com.green.boardver3.user.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
@Tag(name = "유저")
public class UserController {
    private final UserService service;
    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }
    @PostMapping
    @Operation(summary = "회원가입", description = ""+
            "uid:[20] 회원 아이디,<br>"+
            "upw:[100] 회원 비밀번호,<br>"+
            "nm: [30] 회원명,<br>"+
            "gender: [1] 성별(M: 남성, F: 여성),<br>"+
            "addr: [100] 대구시 달서구")
    public int postuser(@RequestBody UserInsDto dto){
        return service.insUser(dto);

    }
    @PostMapping("/login")
    @Operation(summary = "로그인",description = ""+
    "리턴값: "+"(1)로그인성공,"+"(2)아이디없음,"+"(3)비밀번호 다름")
    public int postLoginUser(@RequestBody UserLoninDto dto){
        return service.login(dto);
    }
    @PatchMapping("/pw")
    public int patchUser(@RequestBody UserReDto dto){
        return service.repUser(dto);
    }
}
