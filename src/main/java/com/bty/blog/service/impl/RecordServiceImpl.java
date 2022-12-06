package com.bty.blog.service.impl;

import com.bty.blog.dao.RecordMapper;
import com.bty.blog.entity.Record;
import com.bty.blog.entity.dto.RecordCreateDTO;
import com.bty.blog.entity.dto.RecordEditDTO;
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

    @Override
    public void uploadRecord(RecordCreateDTO recordCreateDTO) {

    }

    @Override
    public void editRecord(RecordEditDTO recordEditDTO) {
        if(recordEditDTO.getCollectionIdList().size()<1){
            throw new RuntimeException("collectionIdList.size() should >= 1");
        }
        recordMapper.editRecord(recordEditDTO.getCid(), recordEditDTO.getTitle(), recordEditDTO.getDescription());
        recordMapper.deleteRecordCollectionByCid(recordEditDTO.getCid());
        recordMapper.insertRecordCollection(recordEditDTO.getCid(), recordEditDTO.getCollectionIdList());
    }

    @Override
    public void deleteRecord(String cid) {
        recordMapper.deleteRecordByCid(cid);
        recordMapper.deleteRecordCollectionByCid(cid);
    }
}
