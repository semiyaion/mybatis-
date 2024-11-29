import com.github.pagehelper.PageHelper;
import com.mybatis.mapper.EmpMapper;
import com.mybatis.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Classname PageTest
 * @Description TODO
 * @Date 2024/11/29 17:04
 * @Created by cxx
 */
public class PageTest {
    @Test
    public void test01() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //在查询功能之前开启分页功能
        PageHelper.startPage(1, 4);
        //当前显示页，每页显示四条
        List<Emp> emps = mapper.selectByExample(null);
        System.out.println(emps);

    }
}
