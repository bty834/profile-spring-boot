package com.bty.blog.service.impl;

import com.bty.blog.dao.UserMapper;
import com.bty.blog.entity.User;
import com.bty.blog.entity.dto.LoginDTO;
import com.bty.blog.service.LoginService;
import com.bty.blog.service.TokenService;
import com.sun.org.apache.xml.internal.security.algorithms.implementations.SignatureDSA;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sun.security.rsa.RSASignature;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static com.bty.blog.util.CodecUtil.encryptBySHA256;

/**
 * @author bty
 * @date 2022/12/2
 * @since 1.8
 **/
@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    @Value("${password.secret}")
    private String salt;


    private final UserMapper userMapper;

    private final TokenService tokenService;

    @Override
    public String startLogin(LoginDTO loginDTO) {

        User user = userMapper.selectUserByUsername(loginDTO.getUsername());
        if(user==null){
            throw new RuntimeException("user not exists");
        }

        String decodedPassword = new String(Base64.getDecoder().decode(loginDTO.getPassword()), StandardCharsets.UTF_8);

        if(!user.getPassword().equals(encryptBySHA256(decodedPassword,salt))){
            throw new RuntimeException("password not right");
        }

        return tokenService.initToken(user);
    }
}
