package Entity;

import Dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

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
            Employee employee = empMapper.getEmpById(1);
            System.out.println(employee);
        }finally {
            session.close();
        }
    }

    @Test
    public void testMybatisConfig() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Employee employee = session.selectOne("EmployeeMapper.selectEmployee", 1);
            System.out.println(employee);
        }finally {
            session.close();
        }
    }

}