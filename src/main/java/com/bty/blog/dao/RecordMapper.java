package com.bty.blog.dao;

import com.bty.blog.entity.Record;
import com.bty.blog.entity.vo.CollectionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author bty
 * @date 2022/11/29
 * @since 1.8
 **/
public interface RecordMapper {

    List<CollectionVO> selectCollectionList();

    List<Record> selectRecordList();

    List<Record> selectRecordListByCollectionId(Integer collectionId);

    void editRecord(@Param("cid") String cid,@Param("title") String title,@Param("description") String description);

    void insertRecordCollection(@Param("cid") String cid,@Param("collectionIdList") List<Integer> colletionIdList);

    void deleteRecordByCid(String cid);

    void deleteRecordCollectionByCid(String cid);
}
