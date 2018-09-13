/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.core.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 *
 * @author 王雁欣
 * create on 2018/3/13 0:56 
 */
@Data
public abstract class BaseModel {

    @Id
    private String id;

    //创建人 设计为用户编码
    private String  createBy;

    //创建时间
    private Long createTime;

    //更新时间
    private Long updateTime;

    //更新人 设计为用户编码
    private String updateBy;

    /**
     * 初始化
     * @return
     */
    public abstract BaseModel init();

}
