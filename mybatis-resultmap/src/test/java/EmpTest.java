import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import resultmaptest.mapper.DeptMapper;
import resultmaptest.mapper.EmpMapper;
import resultmaptest.pojo.Dept;
import resultmaptest.pojo.Emp;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Classname EmpTest
 * @Description TODO
 * @Date 2024/11/28 16:54
 * @Created by cxx
 */
public class EmpTest {
    @Test
    public void test() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp empbyid = mapper.getEmpbyid(1);
        System.out.println(empbyid);

        Emp getinfanddep = mapper.getinfanddep(1);
        System.out.println(getinfanddep);
    }


    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getinfanddepbystepOne(2);
        System.out.println(emp.getEmpId());
        //开启延迟加载后只输出员工的id
    }

    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept empandDeptinfStepOne = mapper.getEmpandDeptinfStepOne(1);
        System.out.println(empandDeptinfStepOne);

    }
}

