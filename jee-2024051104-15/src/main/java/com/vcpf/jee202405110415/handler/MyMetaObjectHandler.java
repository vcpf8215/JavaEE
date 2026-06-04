package com.vcpf.jee202405110415.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * 直接定义元数据，方便审计
 * 主要作用是在插入或更新实体对象时，自动填充一些公共字段的值，例如创建时间、更新时间、创建人、更新人等
 *      这里主要是配置填充策略
 *      做具体的填充实现，即，实现 MetaObjectHandler 接口里的方法即可
 *
 * 代码的主要功能是在数据库插入和更新操作时自动填充 createTime、updateTime、creator 和 modifier 这些字段的值，
 * 以此保证数据的完整性和一致性。
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 在进行插入操作时，自动填充部分字段。具体如下：
     *      createTime：借助 LocalDateTime::now 这个方法引用，将当前的时间设置为创建时间。
     *      updateTime：同样使用 LocalDateTime::now 把当前时间设置为更新时间，在插入时更新时间和创建时间是相同的。
     *      creator：调用 this::getCurrentUser 方法获取当前用户，将其作为创建者。
     *      modifier：调用 this::getCurrentUser 方法获取当前用户，将其作为修改者。
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", LocalDateTime::now, LocalDateTime.class);
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime::now, LocalDateTime.class);
        this.strictInsertFill(metaObject, "creator", this::getCurrentUser, String.class);
        this.strictInsertFill(metaObject, "modifier", this::getCurrentUser, String.class);
    }

    /**
     * 在进行更新操作时自动填充某些字段：
     *      updateTime：利用 LocalDateTime::now 方法引用，把当前时间设置为更新时间。
     *      modifier：调用 this::getCurrentUser 方法获取当前用户，将其作为修改者。
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime::now, LocalDateTime.class);
        this.strictUpdateFill(metaObject, "modifier", this::getCurrentUser, String.class);
    }

    /**
     * 填充策略的具体实现。它接收一个 MetaObject 对象、字段名和一个 Supplier 对象。
     * 若 Supplier 对象提供的值不为空，就把该值设置到 MetaObject 的对应字段中。
     *
     * @param metaObject
     * @param fieldName
     * @param fieldVal
     * @return
     */
    @Override
    public MetaObjectHandler strictFillStrategy(MetaObject metaObject, String fieldName, Supplier<?> fieldVal) {
        Object obj = fieldVal.get();
        if (Objects.nonNull(obj)) {
            metaObject.setValue(fieldName, obj);
        }
        return this;
    }

    /**
     * 模拟获取当前用户，返回一个包含随机数字的字符串，代表当前用户
     * @return
     */
    private String getCurrentUser() {
        return "管理员" + (int) (Math.random() * 10);
    }
}