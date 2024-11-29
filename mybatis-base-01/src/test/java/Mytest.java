import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import testmybatis.mapper.Employee;
import testmybatis.pojo.Course;
import testmybatis.pojo.Emyloyeepojo;

import java.io.IOException;
import java.io.InputStream;

public class Mytest {
    @Test
    public void test01() throws IOException {
        //根据mybatis提供的api进行方法的调用
        //1.读取外部配置文件
        String mybatisConfigFilePath = "mybatis-config.xml";
        InputStream ips = Resources.getResourceAsStream(mybatisConfigFilePath);
        //2.创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);
        //3.根据sqlSessiomFactory创建sqlSession（每次业务创建一个，用完就释放）
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.获取接口的代理对象（代理技术）调用代理对象的方法，就会查找mapper接口的方法
        Employee mapper = sqlSession.getMapper(Employee.class);
        Emyloyeepojo querybyid = mapper.querybyid(1);
        int delbyid = mapper.delbyid(3);
        System.out.println(querybyid);
        if (delbyid == 1) {
            System.out.println("删除成功");
        }
        //5.提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test02() throws IOException {
        //ibatis用法的实现

        //根据mybatis提供的api进行方法的调用
        //1.读取外部配置文件
        String mybatisConfigFilePath = "mybatis-config.xml";
        InputStream ips = Resources.getResourceAsStream(mybatisConfigFilePath);
        //2.创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);
        //3.根据sqlSessiomFactory创建sqlSession（每次业务创建一个，用完就释放）
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.直接使用sqlSession提供的crud方法进行数据库查询
        Course o = (Course) sqlSession.selectOne("kkk", 1);
        System.out.println(o);
    }
}
