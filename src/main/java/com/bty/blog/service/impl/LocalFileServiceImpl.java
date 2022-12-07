package com.bty.blog.service.impl;

import com.bty.blog.BlogApplication;
import com.bty.blog.exception.ExceptionHandler;
import com.bty.blog.service.FileService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author bty
 * @date 2022/12/7
 * @since 1.8
 **/
@Service
@Primary
@RequiredArgsConstructor
public class LocalFileServiceImpl implements FileService {

    public static final String DOWNLOAD_DIR = "/download/";


    private static final Logger LOGGER = LoggerFactory.getLogger(LocalFileServiceImpl.class);


    private final HttpServletRequest request;

    @Override
    public String storeFile(MultipartFile multipartFile) {
        String localFilename = UUID.randomUUID() + multipartFile.getOriginalFilename();
        String path = request.getServletContext().getRealPath(DOWNLOAD_DIR) + localFilename;
        LOGGER.info("file:{} have stored in path:{}",multipartFile.getOriginalFilename(),path);
        File file = new File(path);
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() +DOWNLOAD_DIR+ localFilename;
    }
}
