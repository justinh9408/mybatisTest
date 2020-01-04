package Entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Classname Department
 * @Description TODO
 * @Date 2020-01-01 17:08
 * @Created by Justin
 */
public class Department implements Serializable {

    Integer id;

    String deptName;

    List<Employee> emps;

    public Department() {

    }

    public Department(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                ", emps=" + emps +
                '}';
    }
}

