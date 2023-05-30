package com.green.boardver3.user;

import com.green.boardver3.user.model.UserInsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
