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
    Set<String> MD = new HashSet<String>(){{
        addAll(Arrays.asList("md"));
    }};


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
        if(MD.contains(postfix)){
            return 7;
        }
        return 8;
    }

    /**
     * get the cover image of file , if the file type is image , then take de-sampled origin image as cover
     * @param multipartFile uploaded file
     * @param type //0 image,1 video,2 audio,3 PDF,4 WORD,5 EXCEL,6 SLIDE,7 MD,8 OTHER
     * @return cover img url
     */
    String getCoverImage(MultipartFile multipartFile,Integer type);

    /**
     * @param multipartFile uploaded file
     * @return file url
     */
    String storeFile(MultipartFile multipartFile);

}
