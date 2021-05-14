package com.jt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 响应数据 SysResult对象
 *
 * @author 郑超
 * @create 2021/5/13
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SysResult {

    /**
     * 状态信息: 200表示服务器请求成功 201表示服务器异常
     */
    private Integer status;
    /**
     * 服务器返回的提示信息, 可以为null
     */
    private String msg;
    /**
     * 服务器返回的业务数据, 返回密钥token信息
     */
    private Object data;

    public static SysResult fail() {
        return new SysResult().setStatus(201).setMsg("服务器运行失败！");
    }

    public static SysResult success() {
        return new SysResult().setStatus(200).setMsg("服务器调用成功!");
    }

    public static SysResult success(Object data) {
        return new SysResult().setStatus(200).setMsg("服务器调用成功!").setData(data);
    }

    public static SysResult success(String msg, Object data) {
        return new SysResult().setStatus(200).setMsg(msg).setData(data);
    }

}
