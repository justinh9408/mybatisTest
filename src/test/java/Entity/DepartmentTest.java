package Entity;

import Dao.DepartmentMapper;
import Dao.EmployeeMapperPlus;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * @Classname DepartmentTest
 * @Description TODO
 * @Date 2020-01-02 12:58
 * @Created by Justin
 */
public class DepartmentTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";

        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        InputStream inputStream = resourceAsStream;
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        return sqlSessionFactory;
    }

    @Test
    public void testResultMap() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
            Department dept = departmentMapper.getDeptByIdStep(1);
            System.out.println(dept.getEmps());

        } finally {
            session.close();
        }
    }


}