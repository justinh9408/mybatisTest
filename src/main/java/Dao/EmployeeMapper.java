package Dao;

import Entity.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Classname EmployeeMapper
 * @Description TODO
 * @Date 2019-12-30 14:35
 * @Created by Justin
 */
public interface EmployeeMapper {

    List<Employee> getAllEmps();

    //按照emp id作为key封装map
    @MapKey("id")
    Map<Integer, Employee> getEmpsByLastNameLikeReturnMap(String lastNameLike);

    //列名作为key
    Map<String, Object> getEmpByIdReturnMap(Integer id);

    Employee getEmpById(Integer id);

    Employee getEmpByIdLastName(@Param("id") Integer id, @Param("lastName") String lastName);

    Employee getEmpByIdLastNameWithMap(Map<String, Object> map);


    Boolean addEmployee(Employee employee);

    Boolean updateEmployee(Employee employee);

    void deleteEmployee(Integer id);
}
