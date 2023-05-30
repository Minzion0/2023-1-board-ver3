package com.green.boardver3.user;

import com.green.boardver3.user.model.UserInsDto;
import com.green.boardver3.user.model.UserReDto;
import com.green.boardver3.user.model.UserSelDto;
import com.green.boardver3.user.model.UserSelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {
    private final UserService service;
    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }
    @PostMapping
    public int postuser(@RequestBody UserInsDto dto){
        return service.insUser(dto);

    }
    @GetMapping
    public UserSelVo loginUser(String uid, String upw){
        UserSelDto dto = new UserSelDto();
        dto.setUid(uid);
        dto.setUpw(upw);
        return service.selUser(dto);
    }
    @PatchMapping("/pw")
    public int patchUser(@RequestBody UserReDto dto){
        return service.repUser(dto);
    }
}
