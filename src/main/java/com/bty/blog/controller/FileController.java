package com.bty.blog.controller;

import com.bty.blog.domain.Response;
import com.bty.blog.entity.vo.FileRecordVO;
import com.bty.blog.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

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
        File file = new File("");
        multipartFile.transferTo(file);
        Integer type = fileService.getFileType(file);
        String coverUrl = null;
        if(type==0 || type==1){
            File thumbnailImage = fileService.thumbnailImage(file);
            coverUrl = fileService.storeFile(thumbnailImage);
        }
        String url = fileService.storeFile(file);

        return Response.success(new FileRecordVO(url,coverUrl,type));

    }

    @ApiOperation(value = "上传post中图片")
    @PostMapping("/file/postimg")
    public Response postImage(@RequestBody MultipartFile multipartFile) throws IOException {
        File file = new File("");
        multipartFile.transferTo(file);

        String url = fileService.storeFile(file);
        return Response.success(url);
    }
}
