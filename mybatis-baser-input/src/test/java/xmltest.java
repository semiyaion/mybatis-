import mybatistest.mapper.EmpoyeeMapper;
import mybatistest.pojo.Emyloyeepojo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * @Classname xmltest
 * @Description TODO
 * @Date 2024/11/27 21:16
 * @Created by cxx
 */
public class xmltest {
    @Test
    public void test() throws IOException {
        //读取外部配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //穿件sqlsessionfactory
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取sqlSession对象
        SqlSession sqlSession = build.openSession();
        //获取代理mapper对象
        EmpoyeeMapper mapper = sqlSession.getMapper(EmpoyeeMapper.class);

        Emyloyeepojo emyloyeepojo = mapper.querybuid(1);
        List<Emyloyeepojo> xlc = mapper.querybyname("许良辰");
        for (Emyloyeepojo emyloyeepojo1 : xlc) {
            System.out.println(emyloyeepojo1);
        }

        Emyloyeepojo e1 = new Emyloyeepojo();
        e1.setEmname("李云龙");
        e1.setEmpsalary(1789.6);
        mapper.insertemp(e1);

        List<Emyloyeepojo> list = mapper.querybyidandsalary(2, 7000.4);
        for (Emyloyeepojo emyloyeepojo1 : list) {
            System.out.println(emyloyeepojo1);
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("empid", null);
        map.put("emname", "山本");
        map.put("empsalary", 5689.1);
        int i = mapper.insertemp1(map);
        System.out.println(i);

        List<Emyloyeepojo> qeerybylike = mapper.qeerybylike("良");
        for (Emyloyeepojo emyloyeepojo1 : qeerybylike) {
            System.out.println("模糊查询" + emyloyeepojo1);
        }
        //提交事务
        System.out.println(emyloyeepojo);
        sqlSession.commit();
        sqlSession.close();
    }
}
