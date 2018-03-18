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
public class RestultDate extends Restult {
    /**
     * 返回数据
     */
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public RestultDate(){ }

    public RestultDate(Code code){
        super(code);
    }
    public RestultDate(Code code,Object date){
        super(code);
        this.data = date;
    }

    public RestultDate(int code , String msg , Object object){
        super(code,msg);
        this.data = object;
    }
}
