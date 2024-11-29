package mybatistest.mapper;

import mybatistest.pojo.Emyloyeepojo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmpoyeeMapper {
    Emyloyeepojo querybuid(Integer id);

    //根据id删除员工信息
    int deletebyid(Integer id);

    //根据姓名查询员工信息
    List<Emyloyeepojo> querybyname(String name);

    //实体参数
    //插入员工数据
    int insertemp(Emyloyeepojo emyloyeepojo);

    //根据员工姓名和工资查询员工信息

    List<Emyloyeepojo> querybyidandsalary(@Param("a") Integer id, @Param("b") Double salary);

    //传入map员工数据
    //插入员工数据，传入的是一个map（name=xxx，salary=xxx）
    int insertemp1(Map data);

    //模糊查询
    List<Emyloyeepojo> qeerybylike(@Param("mohu") String mohu);
}
