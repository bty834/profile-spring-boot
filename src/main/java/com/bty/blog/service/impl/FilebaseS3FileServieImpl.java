package com.bty.blog.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.bty.blog.entity.FileType;
import com.bty.blog.service.FileService;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author bty
 * @date 2023/1/21
 * @since 1.8
 **/
@Service
@Primary
public class FilebaseS3FileServieImpl extends BaseS3FileServiceImpl {
    private static final Logger LOGGER = LoggerFactory.getLogger(FilebaseS3FileServieImpl.class);

    public static final String IPFS_GATEWAY = "https://ipfs.filebase.io/ipfs/";

    public FilebaseS3FileServieImpl(AmazonS3 amazonS3) {
        super(amazonS3);
    }


    @Override
    public String getUrlFromPutObjectResult(PutObjectResult result) {
        Map<String, String> userMetadata = result.getMetadata().getUserMetadata();
        String cid = userMetadata.get("cid");
        if(Strings.isNullOrEmpty(cid)){
            LOGGER.error("cid is null or empty");
            throw new RuntimeException("cid null or empty");
        }
        String url = IPFS_GATEWAY + cid;
        LOGGER.info("file url is {}", url);
        return url;
    }

    @Override
    public String doGetCoverUrlFromNonImageFileType(FileType fileType) {
        String url;
        switch (fileType){
            case VIDEO:
                url="https://ipfs.filebase.io/ipfs/QmQTxjr7WGhMxuMrdzQxMGTXT4iCNnSN2BfM1FFU8XQxBn";
                break;
            case AUDIO:
                url="https://ipfs.filebase.io/ipfs/QmYwQ7EN4aEXNSshFjo1U2kSkiqEkpYBVSx1HEqHpu24Yk";
                break;
            case PDF:
                url="https://ipfs.filebase.io/ipfs/QmQTcMNGJZkxzGN2VwqeYmbWMXi2oHnD6pov4m9oceUfB3";
                break;
            case WORD:
                url="https://ipfs.filebase.io/ipfs/QmaHVva1baaqStq3v1HaR1uRaBMXcZoKRe2whSeCLzB9hL";
                break;
            case EXCEL:
                url="https://ipfs.filebase.io/ipfs/QmUifvTpeFrz4aSgXQ7jmbu53XFaL1h7gNVHUhwqGBD4Hf";
                break;
            case PPT:
                url="https://ipfs.filebase.io/ipfs/QmWPZuZdXY4VQr6EqjWGhBSr4oFLUsJxWJGMbxYfLKTgJJ";
                break;
            case MD:
                url="https://ipfs.filebase.io/ipfs/QmUV9Wf7bKxoj6k9y5KY5Yru3nyZbi8zCw4nPPr4Tpe9GP";
                break;
            default:
                url="https://ipfs.filebase.io/ipfs/QmPXnniiYHiFQ9vwLXBX3wBNKGiZUwNCEaVg8tNp5nEReH";
        }
        return url;
    }
}
