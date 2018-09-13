/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.core.service;

import com.biggirlo.core.model.BaseModel;
import com.biggirlo.core.util.Page;
import com.biggirlo.core.util.ReflectionUtils;
import com.mongodb.WriteResult;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.apache.commons.lang.ArrayUtils;


import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.List;

/**
 *
 * @author 王雁欣
 * create on 2018/3/13 0:56 
 */
public class BaseServiceImpl<T extends BaseModel> implements BaseService<T> {

    /**
     * spring mongodb　集成操作类
     */
    @Resource
    protected MongoTemplate mongoTemplate;

    public T save(T entity) {
        entity.setCreateTime(System.currentTimeMillis());
        mongoTemplate.insert(entity);
        return entity;
    }

    public T findById(String id) {
        return mongoTemplate.findById(id, this.getEntityClass());
    }

    public T findById(String id, String collectionName) {
        return mongoTemplate.findById(id, this.getEntityClass(), collectionName);
    }

    public List<T> findAll() {
        return mongoTemplate.findAll(this.getEntityClass());
    }

    public List<T> findAll(String collectionName) {
        return mongoTemplate.findAll(this.getEntityClass(), collectionName);
    }

    public List<T> find(Query query) {
        return mongoTemplate.find(query, this.getEntityClass());
    }

    public T findOne(Query query) {
        return mongoTemplate.findOne(query, this.getEntityClass());
    }

    public Page<T> findPage(Page<T> page, Query query) {
        //如果没有条件 则所有全部
        query = query == null ? new Query(Criteria.where("_id").exists(true)) : query;
        long count = this.count(query);
        // 总数
        page.setTotalCount((int) count);
        int currentPage = page.getCurrentPage();
        int pageSize = page.getPageSize();
        query.skip((currentPage - 1) * pageSize).limit(pageSize);
        List<T> rows = this.find(query);
        page.build(rows);
        return page;
    }

    public long count(Query query) {
        return mongoTemplate.count(query, this.getEntityClass());
    }

    public WriteResult update(Query query, Update update) {
        if (update == null) {
            return null;
        }
        update.pull("updateTime",System.currentTimeMillis());
        return mongoTemplate.updateMulti(query, update, this.getEntityClass());
    }

    public T updateOne(Query query, Update update) {
        if (update == null) {
            return null;
        }
        update.pull("updateTime",System.currentTimeMillis());
        return mongoTemplate.findAndModify(query, update, this.getEntityClass());
    }

    /**
     * 根据传入实体ID更新
     *
     * @param entity
     * @return
     */
    public WriteResult updateById(T entity) {

        Field[] fields = getAllFile();


        if (fields == null || fields.length <= 0) {
            return null;
        }
        Field idField = null;
        // 获取含有@Id 的注解列
        for (Field field : fields) {
            if (field.getName() != null
                    && field.getAnnotation(Id.class) != null) {
                idField = field;
                break;
            }
        }
        //如果找不到 抛异常
        if (idField == null) {
            throw new RuntimeException("can't find annotation id");
        }
        idField.setAccessible(true);
        String id=null;
        try {
            id = (String) idField.get(entity);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if (id == null || "".equals(id.trim())){
            return null;
        }
        //设置当前时间
        entity.setUpdateTime(System.currentTimeMillis());
        // 根据ID更新
        ObjectId objectId = new ObjectId(id);
        Query query = new Query(Criteria.where("_id").is(objectId));
        Update update = ReflectionUtils.getUpdateObj(entity);
        if (update == null) {
            return null;
        }
        return mongoTemplate.updateFirst(query, update, getEntityClass());
    }

    private Field[] getAllFile() {
        Class clazz = this.getEntityClass();
        Field[] fields = clazz.getDeclaredFields();
        while (clazz.getSuperclass() != null){
            fields = (Field[]) ArrayUtils.addAll(fields,clazz.getSuperclass().getDeclaredFields());
            clazz = clazz.getSuperclass();
        }

        return fields;
    }

    public void remove(Query query) {
        mongoTemplate.remove(query, this.getEntityClass());
    }

    public void removeById(String id){
        Query query = new Query(Criteria.where("_id").is(new ObjectId(id)));
        mongoTemplate.remove(query);
    }

    /**
     * 获得泛型类
     */
    private Class<T> getEntityClass() {
        return ReflectionUtils.getSuperClassGenricType(getClass());
    }
}