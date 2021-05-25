package com.jt.controller;

import com.jt.service.FileService;
import com.jt.vo.ImageVo;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author 郑超
 * @create 2021/5/20
 */
@RestController
@CrossOrigin
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public SysResult upload(MultipartFile file) throws IOException {
        ImageVo imageVo = fileService.upload(file);
        if (imageVo == null) return SysResult.fail();
        return SysResult.success().setData(imageVo);
    }

    @DeleteMapping("/deleteFile")
    public SysResult fileRemove(String virtualPath) {
        fileService.removeFile(virtualPath);
        return SysResult.success();
    }

//    @PostMapping("/upload")
//    public SysResult upload(MultipartFile file) throws IOException {
//        //1.获取文件名称
//        String fileName = file.getOriginalFilename();
//        //2.准备文件上传的本地目录
//        String fileDir = "D:/JT_IMAGE/";
//        //3.是否需要判断目录是否存在
//        File filePath = new File(fileDir);
//        if (!filePath.exists()) {
//            //可以创建多级目录
//            boolean mkdirs = filePath.mkdirs();
//            //只创建一级目录
//            //filePath.mkdir();
//        }
//
//        //4.准备输出的对象 文件的全路径="文件目录"/+"文件的名称"
//        String realFilePath = fileDir + fileName;
//        File realFile = new File(realFilePath);
//        //5.实现文件上传
//        file.transferTo(realFile);
//        return SysResult.success();
//    }

}
