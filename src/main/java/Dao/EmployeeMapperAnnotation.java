package Dao;

import Entity.Employee;
import org.apache.ibatis.annotations.Select;

/**
 * @Classname EmployeeMapperAnnotation
 * @Description TODO
 * @Date 2019-12-31 17:05
 * @Created by Justin
 */
public interface EmployeeMapperAnnotation {

    @Select("select * from employee where id = #{id}")
    Employee getEmpById(Integer id);

}
