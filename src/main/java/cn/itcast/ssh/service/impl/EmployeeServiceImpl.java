package cn.itcast.ssh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.ssh.dao.IEmployeeDao;
import cn.itcast.ssh.domain.Employee;
import cn.itcast.ssh.service.IEmployeeService;

/**
 * 员工的业务(CRUD)
 */
@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDao employeeDao;

	/**
	 * 使用用户名作为查询条件，查询用户对象
	 */
	@Override
	public Employee findEmployeeByName(String name) {
		Employee employee = employeeDao.findEmployeeByName(name);
		return employee;
	}

}
