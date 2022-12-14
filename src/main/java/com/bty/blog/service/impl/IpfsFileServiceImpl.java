package com.bty.blog.service.impl;

import com.bty.blog.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author bty
 * @date 2022/12/7
 * @since 1.8
 **/
@Service
@RequiredArgsConstructor
public class IpfsFileServiceImpl implements FileService {

    @Value("${ipfs.filebase.endpoint}")
    private String filebaseEndpoint;

    @Value("${ipfs.filebase.token}")
    private String filebaseToken;


    @Override
    public String getCoverImage(MultipartFile multipartFile, Integer type) {
        return "null";
    }

    @Override
    public String storeFile(MultipartFile multipartFile) {
        return null;
    }
}
