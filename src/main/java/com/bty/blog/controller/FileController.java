package com.bty.blog.controller;

import com.bty.blog.BlogApplication;
import com.bty.blog.domain.Response;
import com.bty.blog.entity.vo.FileRecordVO;
import com.bty.blog.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

/**
 * @author bty
 * @date 2022/12/7
 * @since 1.8
 **/
@Api(value = "文件上传")
@RestController
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;


    @ApiOperation(value = "上传record")
    @PostMapping("/file/record")
    public Response recordFile(@RequestBody MultipartFile multipartFile) throws IOException {

        String originalFilename = multipartFile.getOriginalFilename();
        assert originalFilename != null;
        Integer type = fileService.getFileType(originalFilename);
        String coverUrl  = fileService.thumbnailImage(multipartFile,type);
        String url = fileService.storeFile(multipartFile);

        return Response.success(new FileRecordVO(url,coverUrl,type));
    }

    @ApiOperation(value = "上传post中图片")
    @PostMapping("/file/postImage")
    public Response postImage(@RequestBody MultipartFile multipartFile) throws IOException {

        String originalFilename = multipartFile.getOriginalFilename();
        assert originalFilename != null;
        Integer type = fileService.getFileType(originalFilename);
        if(type!=0){
            throw new RuntimeException("only image allowed!");
        }
        String url = fileService.storeFile(multipartFile);
        return Response.success(Collections.singletonMap("url",url));
    }
}
