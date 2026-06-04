package com.vcpf.jee202405110415.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 实体基类：
 * 		1. 表主键字段，创建人，创建时间，更新人，更新时间，以后称之为业务字段，每个表都有
 * 		2. 主要是封装业务字段，方便审计，方便日志记录和表操作
 * 		3. 封装基类的软件工程目标：方便维护，减少代码冗余
 * 		4. 核心思想：面向对象编程，继承机制
 *	注解使用：
 *		@TableId(value = "id", type = IdType.AUTO) 指定主键的生成策略
 *			本次使用：数据库自增策略，即MySQL的主键自动增长策略
 *		@TableField(fill = FieldFill.INSERT) 在实体类的字段上指定自动填充的策略
 *  自动填充：
 *  	填充策略
 *  	填充实现
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BaseEntity<T extends Model<T>> extends Model<T> {

	@ApiModelProperty(value = "唯一 id，自增")
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@ApiModelProperty(value = "创建人")
	@TableField(fill = FieldFill.INSERT)
	private String creator;

	@ApiModelProperty(value = "创建时间")
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime createTime;

	@ApiModelProperty(value = "更新人")
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String modifier;

	@ApiModelProperty(value = "更新时间")
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateTime;
}