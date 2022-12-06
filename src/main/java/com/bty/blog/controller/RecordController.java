package com.bty.blog.controller;

import com.bty.blog.annotation.Admin;
import com.bty.blog.domain.Response;
import com.bty.blog.entity.dto.RecordCreateDTO;
import com.bty.blog.entity.dto.RecordEditDTO;
import com.bty.blog.service.RecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author bty
 * @date 2022/11/29
 * @since 1.8
 **/
@Api(value = "记录")
@RestController
@RequiredArgsConstructor
public class RecordController {

    private final RecordService recordService;

    @ApiOperation(value = "查询collectionList")
    @GetMapping("/collectionList")
    public Response getCollectionList(){
        return Response.success(recordService.selectCollectionList());
    }

    @ApiOperation(value = "查询Record,返回cid")
    @GetMapping("/recordList")
    public Response getRecordList(){
        return Response.success(recordService.selectRecordList());
    }

    @ApiOperation(value = "根据collectionId查询Record,返回cid")
    @GetMapping("/recordList/collection/{collectionId}")
    public Response getRecordListByCollectionId(@PathVariable("collectionId")Integer collectionId){
        return Response.success(recordService.selectRecordListByCollectionId(collectionId));
    }

    @Admin
    @ApiOperation(value = "新增Record")
    @PostMapping("/record")
    public Response uploadRecord(@RequestBody RecordCreateDTO recordCreateDTO){


        return Response.success();
    }


    @Admin
    @ApiOperation(value = "修改Record")
    @PutMapping("/record")
    public Response editRecord(@RequestBody RecordEditDTO recordEditDTO){
        recordService.editRecord(recordEditDTO);
        return Response.success();
    }

    @Admin
    @ApiOperation(value = "删除Record")
    @DeleteMapping("/record/{cid}")
    public Response removeRecord(@PathVariable String cid){
        recordService.deleteRecord(cid);
        return Response.success();
    }

}
