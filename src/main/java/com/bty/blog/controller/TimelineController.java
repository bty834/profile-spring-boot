package com.bty.blog.controller;

import com.bty.blog.annotation.Admin;
import com.bty.blog.domain.Response;
import com.bty.blog.service.TimelineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author bty
 * @date 2022/11/28
 * @since 1.8
 **/
@Api(value = "博客api")
@RestController
@RequiredArgsConstructor
public class TimelineController {

    private final TimelineService timelineService;

    @ApiOperation(value = "查询首页timeline列表")
    @GetMapping("/timeline")
    public Response getTimelineList(){
        return Response.success(timelineService.selectTimelineList());
    }
}
