package com.bty.blog.dao;

import com.bty.blog.entity.Timeline;

import java.util.List;

/**
 * @author bty
 * @date 2022/11/28
 * @since 1.8
 **/
public interface TimelineMapper {



    List<Timeline> selectTimelineList();



}
