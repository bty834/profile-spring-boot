package com.bty.blog.util;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

/**
 * @author bty
 * @date 2022/12/2
 * @since 1.8
 **/
public class CodecUtil {


    public static String encryptBySHA256(String source){
        return Hashing.sha256().hashString(source, StandardCharsets.UTF_8).toString();
    }

}
