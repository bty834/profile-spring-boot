package com.bty.blog.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author bty
 * @date 2022/12/7
 * @since 1.8
 **/
public interface FileService {
    //0图片,1视频,2音频,3PDF,4WORD,5EXCEL,6PPT,7其他
    Set<String> IMAGE = new HashSet<String>(){{
        addAll(Arrays.asList("jpg","png","jpeg","gif"));
    }};
    Set<String> AUDIO = new HashSet<String>(){{
        addAll(Arrays.asList("mp3","wma","aac"));
    }};
    Set<String> VIDEO = new HashSet<String>(){{
        addAll(Arrays.asList("mp4","avi","mpg","mpeg"));
    }};
    Set<String> PDF = new HashSet<String>(){{
        addAll(Arrays.asList("pdf"));
    }};
    Set<String> WORD = new HashSet<String>(){{
        addAll(Arrays.asList("doc"));
    }};
    Set<String> EXCEL = new HashSet<String>(){{
        addAll(Arrays.asList("xls","xlsx"));
    }};
    Set<String> PPT = new HashSet<String>(){{
        addAll(Arrays.asList("ppt","pptx"));
    }};

    default String thumbnailImage(MultipartFile multipartFile,Integer type) {
        return "";
    }

    default Integer getFileType(String filename) {
        int seperatorIdx = filename.lastIndexOf('.');
        String postfix = filename.substring(seperatorIdx + 1).toLowerCase();
        if(IMAGE.contains(postfix)){
            return 0;
        }
        if(VIDEO.contains(postfix)){
            return 1;
        }
        if(AUDIO.contains(postfix)){
            return 2;
        }
        if(PDF.contains(postfix)){
            return 3;
        }
        if(WORD.contains(postfix)){
            return 4;
        }
        if(EXCEL.contains(postfix)){
            return 5;
        }
        if(PPT.contains(postfix)){
            return 6;
        }
        return 7;
    }

    /**
     * @param file
     * @return url
     */
    String storeFile(MultipartFile multipartFile);

}
