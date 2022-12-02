package com.bty.blog.service.impl;

import com.bty.blog.dao.RecordMapper;
import com.bty.blog.entity.Record;
import com.bty.blog.entity.vo.CollectionVO;
import com.bty.blog.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bty
 * @date 2022/11/29
 * @since 1.8
 **/
@Service
@RequiredArgsConstructor
public class RecordServiceImpl implements RecordService {

    private final RecordMapper recordMapper;

    @Override
    public List<CollectionVO> selectCollectionList() {
        return recordMapper.selectCollectionList();
    }

    @Override
    public List<Record> selectRecordList() {
        return recordMapper.selectRecordList();
    }

    @Override
    public List<Record> selectRecordListByCollectionId(Integer collectionId) {
        return recordMapper.selectRecordListByCollectionId(collectionId);
    }
}
