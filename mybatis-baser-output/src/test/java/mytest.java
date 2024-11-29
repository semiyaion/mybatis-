import mybatisdemo.mapper.Emyloyeemapper;
import mybatisdemo.pojo.Emyloyeepojo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Classname mytest
 * @Description TODO
 * @Date 2024/11/28 14:02
 * @Created by cxx
 */
public class mytest {
    @Test
    public void test01() throws IOException {
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(ips);

        SqlSession sqlSession = factory.openSession();

        Emyloyeemapper mapper = sqlSession.getMapper(Emyloyeemapper.class);

        Double querysalarybyid = mapper.querysalarybyid(1);

        String querynamebuid = mapper.querynamebuid(32);

        List<String> querynamesbysa = mapper.querynamesbysa(1000.4);

        for (String s : querynamesbysa) {
            System.out.println(s);
        }

        System.out.println(querynamebuid);
        System.out.println(querysalarybyid);

        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void test02() throws IOException {
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(ips);

        SqlSession sqlSession = build.openSession();

        Emyloyeemapper mapper = sqlSession.getMapper(Emyloyeemapper.class);
        List<Emyloyeepojo> employee = mapper.getemp("employee");
        employee.forEach(System.out::println);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test03() throws IOException {
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(ips);

        SqlSession sqlSession = build.openSession();

        Emyloyeemapper mapper = sqlSession.getMapper(Emyloyeemapper.class);
        Emyloyeepojo emyloyeepojo = new Emyloyeepojo(null, "刘毅", 569.4);
        mapper.insertemp(emyloyeepojo);
        System.out.println(emyloyeepojo);


        sqlSession.commit();
        sqlSession.close();
    }


}
