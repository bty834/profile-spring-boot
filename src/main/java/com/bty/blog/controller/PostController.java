package com.bty.blog.controller;

import com.bty.blog.annotation.Admin;
import com.bty.blog.domain.Response;
import com.bty.blog.entity.dto.CommentDTO;
import com.bty.blog.entity.dto.PostCreateDTO;
import com.bty.blog.entity.dto.PostEditDTO;
import com.bty.blog.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author bty
 * @date 2022/11/28
 * @since 1.8
 **/
@Api(value = "博客api")
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @ApiOperation(value = "查询post列表")
    @GetMapping("/postList")
    public Response getPostCardList(){
        return Response.success(postService.selectPostCardList());
    }

    @ApiOperation(value = "根据postId查询post详情")
    @GetMapping("/post/{postId}")
    public Response getPostDetailById(@PathVariable("postId") Integer postId){
        return Response.success(postService.selectPostDetailById(postId));
    }

    @Admin
    @ApiOperation(value = "新增post")
    @PostMapping("/post")
    public Response createPost(@RequestBody PostCreateDTO postCreateDTO){
        postService.createPost(postCreateDTO);
        return Response.success();
    }

    @Admin
    @ApiOperation(value = "修改post")
    @PutMapping("/post")
    public Response editPost(@RequestBody PostEditDTO postEditDTO){
        postService.editPost(postEditDTO);
        return Response.success();
    }

    @Admin
    @ApiOperation(value = "删除post")
    @DeleteMapping("/post/{postId}")
    public Response removePost(@PathVariable Integer postId){
        postService.removePost(postId);
        return Response.success();
    }





    @ApiOperation(value = "查询所有postId")
    @GetMapping("/postIdList")
    public Response getPostIdList(){
        return Response.success(postService.selectPostIdList());
    }


    @ApiOperation(value = "查询所有的tag")
    @GetMapping("/tagList")
    public Response getTagList(){
        return Response.success(postService.selectTagList());
    }
    @ApiOperation(value = "查询该postId所有的tag")
    @GetMapping("/tag/{postId}")
    public Response getTagListByPostId(@PathVariable("postId") Integer postId){
        return Response.success(postService.selectTagListByPostId(postId));
    }

    @ApiOperation(value = "查询最近发的post")
    @GetMapping("/recentPostList/{limit}")
    public Response getRecentPostList(@PathVariable("limit") Integer limit){
        return Response.success(postService.selectRecentPostList(limit));
    }

    @ApiOperation(value = "查询该tag下所有的post")
    @GetMapping("/tagPostList/{tagId}")
    public Response getPostCardListByTagId(@PathVariable("tagId") Integer tagId){
        return Response.success(postService.selectPostCardListByTagId(tagId));
    }

    @ApiOperation(value = "查询该post所有的comment")
    @GetMapping("/comment/{postId}")
    public Response getCommentListByPostId(@PathVariable("postId") Integer postId){
        return Response.success(postService.selectCommentListByPostId(postId));
    }

    @ApiOperation(value = "添加评论")
    @PostMapping("/comment")
    public Response submitComment(@RequestBody CommentDTO comment){
        postService.insertComment(comment);
        return Response.success("插入成功");
    }



    @ApiOperation(value = "查询所有tagId")
    @GetMapping("/tagIdList")
    public Response getTagIdList(){
        return Response.success(postService.selectTagIdList());
    }

    @Admin
    @ApiOperation(value = "添加tag")
    @PostMapping("/tag/{tagName}")
    public Response createTag(@PathVariable String tagName){
        return Response.success(postService.insertTag(tagName));
    }


    @Admin
    @ApiOperation(value = "修改tag")
    @PutMapping("/tag")
    public Response editTag( Integer tagId,String tagName){
        return Response.success(postService.editTag(tagId,tagName));
    }

    @Admin
    @ApiOperation(value = "修改tag")
    @DeleteMapping("/tag/{tagId}")
    public Response removeTag(@PathVariable Integer tagId){
        return Response.success(postService.deleteTagById(tagId));
    }



}
