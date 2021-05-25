package com.jt.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 郑超
 * @create 2021/5/17
 */
@Data
@Accessors(chain = true)
public class PageResult {

    private String query;
    private Integer pageNum;
    private Integer pageSize;
    private Long total;
    private Object rows;

}
