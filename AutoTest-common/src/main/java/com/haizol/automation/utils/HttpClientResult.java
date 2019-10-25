package com.haizol.automation.utils;

import java.io.Serializable;

/**
 * @Classname HttpClientResult
 * @Date 2019/10/16 22:54
 * @Created by StevenZsh
 * @Description TODO
 */
public class HttpClientResult implements Serializable {

    /**
     * 响应状态码
     */
    private int code;

    /**
     * 响应数据
     */
    private String content;
}
