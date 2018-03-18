package com.biggirlo.core.http.response;

 /**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 *
 * 返回对象
 * @author 王雁欣
 * create on 2017/8/30 23:36
 */
public class Restult {

    /**
     * 状态码
     */
    private Long code;

    /**
     * 返回码
     */
    private String msg;

     public Restult(){

     }

    public Restult(Code code){
        this.code = code.value();
        this.msg = code.msg();
    }

    public Restult(long code , String msg){
        this.code = code;
        this.msg = msg;
    }



    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
