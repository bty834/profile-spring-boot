package com.bty.blog.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author bty
 * @date 2022/12/7
 * @since 1.8
 **/
public interface FileService {

    default File thumbnailImage(File file) {
        return null;
    }

    default Integer getFileType(File file){
        return null;
    }

    /**
     *
     * @param file
     * @return url
     */
    String storeFile(File file);

}
