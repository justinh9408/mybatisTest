package Dao;

import Entity.Department;

/**
 * @Classname DepartmentMapper
 * @Description TODO
 * @Date 2020-01-02 12:15
 * @Created by Justin
 */
public interface DepartmentMapper {

    Department getDeptById(Integer id);

    Department getDeptByIdPlus(Integer id);

    Department getDeptByIdStep(Integer id);
}
