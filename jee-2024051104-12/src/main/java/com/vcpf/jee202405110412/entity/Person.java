package com.vcpf.jee202405110412.entity;
import java.io.Serializable;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * 人员（编号，姓名，性别，年龄，身份证）
 * 人员-身份证：一对一关系
 * @author vcpf
 */
@Entity
@Table(name="person_table")
/**解决No serializer found for class org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor异常*/
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
@Data
public class Person implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //自动递增的主键
    private int id;
    private String pname;
    private String psex;
    private int page;
    @OneToOne(
            // 可以为空，即人可无卡
            optional = true,
            // 懒加载，另一个是急加载 EAGER
            fetch = FetchType.LAZY,
            // 关联的实体类型
            targetEntity = IdCard.class,
            // 级联关系【保存，删除，刷新，更新=PERSIST,REMOVE,REFRESH,MERGE; 而ALL即全部】
            cascade = CascadeType.ALL
    )
    // 20260403-243-todo
    /*指明Person对应表的id_Card_id列作为外键与IdCard对应表的id列进行关联unique= true 指明id_Card_id列的值不可重复*/
    @JoinColumn(
            name = "id_Card_id",
            referencedColumnName = "id",
            unique= true
    )
    @JsonIgnore
    /*如果A对象持有B的引用，B对象持有A的引用，这样就形成了循环引用，如果直接使用json转换会报错，使用@JsonIgnore解决该错误。*/
    private IdCard idCard;
}
