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
        if(recordCreateDTO.getCollectionIdList().size()<1){
            throw new RuntimeException("collectionIdList.size() should >= 1");
        }

        recordMapper.insertRecord(recordCreateDTO);
        Integer recordId = recordMapper.selectRecordIdByTitle(recordCreateDTO.getTitle());
        recordMapper.deleteRecordCollectionByRecordId(recordId);
        recordMapper.insertRecordCollection(recordId, recordCreateDTO.getCollectionIdList());
    }


    @Override
    public void editRecord(RecordEditDTO recordEditDTO) {
        if(recordEditDTO.getCollectionIdList().size()<1){
            throw new RuntimeException("collectionIdList.size() should >= 1");
        }
        recordMapper.editRecord(recordEditDTO.getId(), recordEditDTO.getTitle(), recordEditDTO.getDescription());
        recordMapper.deleteRecordCollectionByRecordId(recordEditDTO.getId());
        recordMapper.insertRecordCollection(recordEditDTO.getId(), recordEditDTO.getCollectionIdList());
    }

    @Override
    public void deleteRecord(Integer id) {
        recordMapper.deleteRecordById(id);
        recordMapper.deleteRecordCollectionByRecordId(id);
    }
}
