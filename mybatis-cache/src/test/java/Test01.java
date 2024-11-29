import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import testcache.mapper.EmpMapper;
import testcache.pojo.Emp;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Classname Test01
 * @Description TODO
 * @Date 2024/11/29 10:49
 * @Created by cxx
 */
public class Test01 {
    @Test
    public void test1() throws IOException {

        /*
         * mybatis的一级缓存
         * 一级缓存时sqlsession级别的，即通过同一个sqlsession查询的数据会被缓存
         * 再次使用同一个sqlsession查询同一条数据，会从缓存中获取
         * 失效的四种情况
         * 1）不同的sqlsession对应不同的一级缓存
         * 2）同一个sqlsession但查询条件不同
         * 3）同一个sqlsession两次查询期间执行了任意一次的增删改操作
         * 4）同一个sqlsession俩次查询期间内手动清空了缓存*/
        /*
        * mybatis的二级缓存
        * 1.需要全局设置属性cacheEnabled=true，默认为true
        * 2.在映射文件中设置标签<cache>
          3.在二级缓存必须在sqlsession关闭或提交后有效
          4.查询的数据所转换的实体类类型必须实现序列化接口
          *
          * 二级缓存失效：在俩次查询之间执行了任意的增删改，会使一级和二级缓存失效
          * */
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        EmpMapper mapper1 = sqlSession1.getMapper(EmpMapper.class);
        Emp emp1 = mapper1.getEmpbyid(1);
        System.out.println(emp1);
        sqlSession1.close();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        EmpMapper mapper2 = sqlSession2.getMapper(EmpMapper.class);
        Emp emp2 = mapper2.getEmpbyid(1);
        System.out.println(emp2);
    }
}
