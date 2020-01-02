package Dao;

import Entity.Employee;

import java.util.List;

/**
 * @Classname EmployeeMapperPlus
 * @Description TODO
 * @Date 2020-01-01 16:32
 * @Created by Justin
 */
public interface EmployeeMapperPlus {

    Employee getEmpById(Integer id);

    Employee getEmpDeptById(Integer id);

    Employee getEmpByIdStep(Integer id);

    List<Employee> getEmpsByDptId(Integer dptId);

}
