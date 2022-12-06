package com.bty.blog.service.impl;

import com.bty.blog.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author bty
 * @date 2022/12/7
 * @since 1.8
 **/
@Service("IPFS")
@Primary
@RequiredArgsConstructor
public class IpfsFileServiceImpl implements FileService {


    @Override
    public String storeFile(File file) {
        return null;
    }
}
