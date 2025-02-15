package com.sky.service;

import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.result.PageResult;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    //新增员工的方法
    void save(EmployeeDTO employeeDTO);
    //分页查询
    PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO);
    //启用禁用员工账号
    void startOrstop(Integer status, Long id);
}
