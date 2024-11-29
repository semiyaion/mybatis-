import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import test123.mapper.EmpMapper;
import test123.pojo.Emp;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Test01
 * @Description TODO
 * @Date 2024/11/29 9:04
 * @Created by cxx
 */

public class Test01 {
    @Test
    public void test001() throws IOException {
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(ips);

        SqlSession sqlSession = build.openSession();

        Emp emp = new Emp(null, "张三", 20, "男");
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = mapper.getempbyCondition(emp);
        list.forEach(System.out::println);

        List<Emp> emps = mapper.getempbyChoose(emp);
        emps.forEach(System.out::println);

//        List<Emp> emps = mapper.getempbyChoose(emp);
//        emps.forEach(System.out::println);
//        Emp emp1 = new Emp(null,"小明",20,"男");
//        Emp emp2 = new Emp(null,"小美",20,"男");
//        Emp emp3 = new Emp(null,"小张",20,"男");
//        ArrayList<Emp> emps1 = new ArrayList<>();
//        emps1.add(emp1);
//        emps1.add(emp2);
//        emps1.add(emp3);
//        mapper.insertMpreEmp(emps1);


//        Integer[] empIds=new Integer[]{9,10,11};
//        mapper.deleteMoreEmp(empIds);


        sqlSession.commit();
        sqlSession.close();
    }
}
