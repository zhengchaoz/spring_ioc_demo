package com.jt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author 刘昱江
 * 时间 2021/4/7
 */
@EqualsAndHashCode(callSuper = true)
@TableName("item")
@Data
@Accessors(chain = true)
public class Item extends BasePojo {

    @TableId(type = IdType.AUTO)
    private Integer id;         //商品Id号
    private String title;       //商品标题信息
    private String sellPoint;   //卖点信息
    private Integer price;      //商品价格
    private Integer num;        //商品数量
    private String images;      //商品图片
    private Integer itemCatId;  //商品分类ID号
    private Boolean status;     //状态信息    0 下架 1 上架

}
