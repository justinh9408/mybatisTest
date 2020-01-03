package Dao;

import Entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname EmployeeMapperDynamicSql
 * @Description TODO
 * @Date 2020-01-02 19:17
 * @Created by Justin
 */
public interface EmployeeMapperDynamicSql {

    List<Employee> findEmpWithConditionIf(Employee employee);

    List<Employee> findEmpWithIfandTrim(Employee employee);

    List<Employee> findEmpWithChoose(Employee employee);

    void updateEmpSet(Employee employee);

    List<Employee> findEmpsWithForeach(List<Integer> ids);

    void addEmps(@Param("emps") List<Employee> emps);

}
