package com.jt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author 郑超
 * @create 2021/5/21
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class ImageVo implements Serializable {

    private String virtualPath; // 虚拟路径，不带盘符
    private String urlPath;     // 访问图片的网络地址
    private String fileName;    // 图片名称

}
