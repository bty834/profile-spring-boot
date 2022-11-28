package com.bty.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author bty
 * @date 2022/11/28
 * @since 1.8
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostTag {
    private Integer id;
    private Integer postId;
    private Integer tag_id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created;
}
