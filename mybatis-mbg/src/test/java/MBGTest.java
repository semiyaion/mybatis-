import com.mybatis.mapper.EmpMapper;
import com.mybatis.pojo.Emp;
import com.mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Classname MBGTest
 * @Description TODO
 * @Date 2024/11/29 16:11
 * @Created by cxx
 */
public class MBGTest {
    @Test
    public void test() throws IOException {
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(ips);
        SqlSession sqlSession = build.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.selectByPrimaryKey(1);
        System.out.println(emp);
        EmpExample empExample = new EmpExample();
        empExample.createCriteria().andEmpNameLike("张%");
        List<Emp> emps = mapper.selectByExample(empExample);
        emps.forEach(System.out::println);
    }

}
