package com.bty.blog.service.impl;

import com.bty.blog.dao.PostMapper;
import com.bty.blog.entity.dto.CommentDTO;
import com.bty.blog.entity.vo.*;
import com.bty.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bty
 * @date 2022/11/28
 * @since 1.8
 **/
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostMapper postMapper;

    @Override
    public List<PostCard> selectPostCardList() {
        List<PostCard> postCards = postMapper.selectPostCardList();

        for (PostCard postCard : postCards) {
            Integer postId = postCard.getId();
            List<TagVO> tagList = selectTagListByPostId(postId);
            postCard.setTagList(tagList);
        }
        return postCards;
    }

    @Override
    public PostDetail selectPostDetailById(Integer id) {
        return postMapper.selectPostDetailById(id);
    }

    @Override
    public List<TagVO> selectTagListByPostId(Integer postId) {
        return postMapper.selectTagListByPostId(postId);
    }

    @Override
    public List<PostVO> selectRecentPostList(Integer limit) {
        return postMapper.selectRecentPostList(limit);
    }

    @Override
    public List<Integer> selectPostIdList() {
        return postMapper.selectPostIdList();
    }

    @Override
    public List<PostCard> selectPostCardListByTagId(Integer tagId) {
        List<PostCard> postCards = postMapper.selectPostCardListByTagId(tagId);
        for (PostCard postCard : postCards) {
            Integer postId = postCard.getId();
            List<TagVO> tagList = selectTagListByPostId(postId);
            postCard.setTagList(tagList);
        }
        return postCards;
    }

    @Override
    public List<TagVO> selectTagList() {
        return postMapper.selectTagList();
    }

    @Override
    public List<Integer> selectTagIdList() {
        return postMapper.selectTagIdList();
    }

    @Override
    public List<CommentVO> selectCommentListByPostId(Integer postId) {
        return postMapper.selectCommentByPostId(postId);
    }

    @Override
    public void insertComment(CommentDTO comment) {
        postMapper.insertComment(comment);
    }


}
