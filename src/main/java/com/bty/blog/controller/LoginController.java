package com.bty.blog.controller;

import com.bty.blog.domain.Response;
import com.bty.blog.entity.dto.LoginDTO;
import com.bty.blog.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bty
 * @date 2022/12/2
 * @since 1.8
 **/
@Api(value = "记录")
@RestController
@RequiredArgsConstructor
public class LoginController {
    private static final String TOKEN = "token";

    private final LoginService loginService;

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public Response login(@RequestBody LoginDTO loginDTO){
        String token = loginService.startLogin(loginDTO);
        Map<String, String> map = Collections.singletonMap(TOKEN, token);
        return Response.success(map);
    }

}
