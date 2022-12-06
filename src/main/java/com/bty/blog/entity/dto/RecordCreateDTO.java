package com.bty.blog.entity.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author bty
 * @date 2022/12/6
 * @since 1.8
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel("记录添加")
public class RecordCreateDTO {
    private MultipartFile file;
    private String title;
    private String description;
    private List<Integer> collectionIdList;
}
