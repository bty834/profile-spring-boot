package com.bty.blog.service.impl;

import com.bty.blog.service.FileService;
import lombok.RequiredArgsConstructor;
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
public class OssFileServiceImpl implements FileService {

    @Override
    public String storeFile(MultipartFile multipartFile) {
        return null;
    }
}
