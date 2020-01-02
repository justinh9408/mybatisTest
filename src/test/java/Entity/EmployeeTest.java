package Entity;

import Dao.EmployeeMapper;
import Dao.EmployeeMapperAnnotation;
import Dao.EmployeeMapperPlus;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname EmployeeTest
 * @Description TODO
 * @Date 2019-12-30 14:14
 * @Created by Justin
 */
public class EmployeeTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    @Test
    public void testInterfaceMapper() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            EmployeeMapper empMapper = session.getMapper(EmployeeMapper.class);

            Employee employee = empMapper.getEmpById(2);
            System.out.println(employee);

            Map<Integer, Employee> empsByLastNameLikeReturnMap = empMapper.getEmpsByLastNameLikeReturnMap("jer%");
            System.out.println(empsByLastNameLikeReturnMap);

            Map<String, Object> empByIdReturnMap = empMapper.getEmpByIdReturnMap(2);
            System.out.println(empByIdReturnMap);

        }finally {
            session.close();
        }
    }


    @Test
    public void testMultiParam() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            EmployeeMapper empMapper = session.getMapper(EmployeeMapper.class);
//            Employee employee = empMapper.getEmpByIdLastName(2, "tom");
            Map<String, Object> map = new HashMap<>();
            map.put("id",2);
            map.put("lastName", "tom");
            Employee employee = empMapper.getEmpByIdLastNameWithMap(map);
            System.out.println(employee);
        }finally {
            session.close();
        }
    }

    @Test
    public void testMapperAnnotation() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            EmployeeMapperAnnotation empMapper = session.getMapper(EmployeeMapperAnnotation.class);
            Employee employee = empMapper.getEmpById(1);
            System.out.println(employee);
        }finally {
            session.close();
        }
    }

    @Test
    public void testCUD() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try{
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
            Employee employee1 = new Employee(null, "jerry", "jjn@gmail.com", "0");
            mapper.addEmployee(employee1);
            System.out.println(employee1.id);

//            Employee employee2 = new Employee(21, "tom", "tt@gg.com", "1");
//            System.out.println(mapper.updateEmployee(employee2));
            //手动提交
            session.commit();
        }finally {
            session.close();
        }
    }

    @Test
    public void testMybatisConfig() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Employee employee = session.selectOne("Dao.EmployeeMapper.getEmpById", 2);
            System.out.println(employee);
        }finally {
            session.close();
        }
    }


    @Test
    public void testResultMap() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            EmployeeMapperPlus mapperPlus = session.getMapper(EmployeeMapperPlus.class);
            Employee empByIdStep = mapperPlus.getEmpByIdStep(2);
            System.out.println(empByIdStep);
        }finally {
            session.close();
        }
    }


}