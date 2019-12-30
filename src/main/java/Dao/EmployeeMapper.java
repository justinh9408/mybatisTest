package Dao;

import Entity.Employee;

/**
 * @Classname EmployeeMapper
 * @Description TODO
 * @Date 2019-12-30 14:35
 * @Created by Justin
 */
public interface EmployeeMapper {

    Employee getEmpById(Integer id);
}
