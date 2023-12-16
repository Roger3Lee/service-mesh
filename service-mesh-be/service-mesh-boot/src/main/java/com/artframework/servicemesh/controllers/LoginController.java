package com.artframework.servicemesh.controllers;

import cn.hutool.core.lang.UUID;
import com.artframework.servicemesh.vo.LoginVO;
import com.artframework.servicemesh.vo.UserInfoVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class LoginController {

    @PostMapping("login")
    public String login(@RequestBody LoginVO loginVO) {
        assert loginVO.getUserName().equals("admin");
        assert loginVO.getPassword().equals("123456");
        return UUID.fastUUID().toString(true);
    }

    @GetMapping("/info")
    public UserInfoVO userInfo() {
        UserInfoVO vo = new UserInfoVO();
        vo.setUsername("admin");
        vo.setRoles(new String[]{"admin", "editor"});
        return vo;
    }
}
