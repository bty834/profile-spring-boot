package com.bty.blog.dao;

import com.bty.blog.entity.dto.CommentDTO;
import com.bty.blog.entity.vo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author bty
 * @date 2022/11/28
 * @since 1.8
 **/
public interface PostMapper {


    List<PostCard> selectPostCardList();

    PostDetail selectPostDetailById(Integer id);

    List<Integer> selectPostIdList();

    List<Integer> selectTagIdList();

    List<TagVO> selectTagListByPostId(Integer postId);

    List<PostVO> selectRecentPostList(Integer limit);

    List<PostCard> selectPostCardListByTagId(Integer tagId);

    List<TagVO> selectTagList();

    List<CommentVO> selectCommentByPostId(Integer postId);


    void insertComment(@Param("comment") CommentDTO comment);

}
