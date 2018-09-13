/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 *
 *
 */
package com.biggirlo.core.http;

import lombok.Data;

import java.util.List;

/**
 * datatables 请求对象封装
 *  @author 王雁欣
 * create on 2017/9/21 22:16
 */
@Data
public class DataTablesParam {

    //页码，从1开始
    private int start;

    //一页长度
    private int length;

    //总长度
    private Long recordsTotal;

    private Long recordsFiltered;

    //数据
    private List<Object> data;

}
