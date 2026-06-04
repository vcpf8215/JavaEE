package com.vcpf.emsdemo.service.Impl;

import com.vcpf.emsdemo.dao.EmpDao;
import com.vcpf.emsdemo.entity.Emp;
import com.vcpf.emsdemo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmpDao empDao;

	@Override
	public List<Emp> findAll() {
		return empDao.selectAllObjs();
	}

	@Override
	public void save(Emp emp) {
		empDao.insertObj(emp);
	}

	@Override
	public void alter(Emp emp) {
		empDao.updateObj(emp);
	}

	@Override
	public Emp findEmpById(String id) {
		return empDao.selectObjById(id);
	}

	@Override
	public void remove(String id) {
		empDao.deleteObj(id);
	}

}