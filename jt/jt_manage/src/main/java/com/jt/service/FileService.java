package com.jt.service;

import com.jt.vo.ImageVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author 郑超
 * @create 2021/5/21
 */
public interface FileService {

    ImageVo upload(MultipartFile file) throws IOException;

    void removeFile(String virtualPath);
}
