package com.biggirlo.core.service;

import com.biggirlo.core.util.Page;
import com.mongodb.WriteResult;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;
/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 *
 * @author 王雁欣
 * create on 2018/3/13 0:55
 */
public interface BaseService<T> {


    public T save(T entity) ;

    public T findById(String id);

    public T findById(String id, String collectionName);

    public List<T> findAll();

    public List<T> findAll(String collectionName) ;

    public List<T> find(Query query);

    public T findOne(Query query);

    public Page<T> findPage(Page<T> page, Query query) ;

    public long count(Query query);

    public WriteResult update(Query query, Update update);

    public T updateOne(Query query, Update update);

    public WriteResult update(T entity) ;

    public void remove(Query query) ;
}
