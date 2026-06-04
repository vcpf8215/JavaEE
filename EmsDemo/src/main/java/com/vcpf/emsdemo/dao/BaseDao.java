package com.vcpf.emsdemo.dao;

import java.util.List;

/**
 * 这个公共接口，是为了统一命令，不需要实现
 * @param <T>
 * @param <K>
 */
public interface BaseDao<T,K> {

	void insertObj(T t);
	void updateObj(T t);
	void deleteObj(K id);
	T selectObjById(K id);
	List<T> selectAllObjs();
	Long getTotalObjsCount();
	List<T> selectObjsByPage(Integer start, Integer size);
}