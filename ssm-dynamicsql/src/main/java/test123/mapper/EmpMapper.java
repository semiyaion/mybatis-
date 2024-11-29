package test123.mapper;

import org.apache.ibatis.annotations.Param;
import test123.pojo.Emp;

import java.util.List;

/**
 * @Classname EmpMapper
 * @Description TODO
 * @Date 2024/11/29 8:55
 * @Created by cxx
 */
public interface EmpMapper {

    //多条件查询
    List<Emp> getempbyCondition(Emp emp);

    List<Emp> getempbyChoose(Emp emp);


    //批量添加员工信息
    void insertMpreEmp(@Param("emps") List<Emp> emps);

    //批量删除员工信息
    void deleteMoreEmp(@Param("empIds") Integer[] empIds);
}
