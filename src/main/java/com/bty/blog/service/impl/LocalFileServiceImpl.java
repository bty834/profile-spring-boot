package com.bty.blog.service.impl;


import com.bty.blog.entity.FileType;
import com.bty.blog.entity.S3Key;
import com.bty.blog.service.FileService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * @author bty
 * @date 2022/12/7
 * @since 1.8
 **/
@Service
@RequiredArgsConstructor
public class LocalFileServiceImpl implements FileService {

    public static final String DOWNLOAD_DIR = "/download/";

    private static final Logger LOGGER = LoggerFactory.getLogger(LocalFileServiceImpl.class);


    private final HttpServletRequest request;

    @Override
    public String handleCover(MultipartFile multipartFile) {
        String originalFilename = multipartFile.getOriginalFilename();
        assert originalFilename != null;
        FileType type = FileType.of(getFileExtention(originalFilename));

        if(type.equals(FileType.IMAGE)){
            return "";
        }
        if(type.equals(FileType.VIDEO)||type.equals(FileType.AUDIO)){
            return getFileUrl(request,"video.jpg");
        }

        return getFileUrl(request,"file.jpg");
    }

    public static String getFileUrl(HttpServletRequest request,String fileName){
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + DOWNLOAD_DIR + fileName;
    }


    @Override
    public String storeFile(MultipartFile multipartFile, Map<String,Object> meta) {
        String localFilename = buildFilename(multipartFile.getOriginalFilename());
        String path = request.getServletContext().getRealPath(DOWNLOAD_DIR) + localFilename;
        LOGGER.info("file:{} have stored in path:{}",multipartFile.getOriginalFilename(),path);
        File file = new File(path);
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return getFileUrl(request,localFilename);
//        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() +DOWNLOAD_DIR+ localFilename;
    }
}
