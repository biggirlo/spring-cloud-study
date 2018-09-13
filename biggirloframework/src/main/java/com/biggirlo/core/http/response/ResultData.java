/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.core.http.response;

/**
 *
 * @author 王雁欣
 * create on 2018/3/15 21:17 
 */
public class ResultData extends Result {
    /**
     * 返回数据
     */
    private Object data;

    public ResultData(Result result, Object date){
        super(result.getCode(),result.getMsg());
        this.data = date;
    }

}
