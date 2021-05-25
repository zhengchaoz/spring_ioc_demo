package com.jt.service;

import com.jt.vo.ImageVo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

/**
 * @author 郑超
 * @since 2021/5/21
 */
@Service
public class FileServiceImpl implements FileService{

    private String localFileDir = "/usr/local/src/images";
    private String localUrlDir = "http://image.jt.com";

    @Override
    public ImageVo upload(MultipartFile file) throws IOException {
        // 判断文件后缀
        String filename = file.getOriginalFilename();
        if (!filename.matches("^.+(\\.(gif|png|jpg|jpeg|webp|svg|psd|bmp|tif))$")) return null;
        // 判断文件内容，是否具有分别率
        BufferedImage read = ImageIO.read(file.getInputStream());
        if (read.getWidth() <= 0 || read.getHeight() <= 0) return null;
        // 实现图片分目录存储
        String format = new SimpleDateFormat("/yyyy/MM/dd/").format(new Date());
        String localDir = localFileDir + format;
        // 创建目录
        File localFile = new File(localDir);
        if (!localFile.exists()) localFile.mkdirs();
        // 防止文件重名
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String fileType = filename.substring(filename.lastIndexOf("."));
        String fileAll = uuid + fileType;
        // 将上传文件另存为
        File realFile = new File(localDir + fileAll);
        file.transferTo(realFile);
        return new ImageVo(format + fileAll, localUrlDir + format + fileAll, fileAll);
    }

    @Override
    public void removeFile(String virtualPath) {
        String filePath = localUrlDir + virtualPath;
        File file = new File(filePath);
        file.delete();
    }
}
