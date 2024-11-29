package resultmaptest.mapper;

import org.apache.ibatis.annotations.Param;
import resultmaptest.pojo.Emp;

/**
 * @Classname EmpMapper
 * @Description TODO
 * @Date 2024/11/28 16:48
 * @Created by cxx
 */
public interface EmpMapper {
    Emp getEmpbyid(@Param("empid") Integer empid);


    Emp getinfanddep(@Param("id") Integer id);

    //这是查询员工以及对应部门信息的第一步
    Emp getinfanddepbystepOne(@Param("id") Integer id);

    //这是多表查询的第二步
    Emp getinfanddepbystepTwo(@Param("id") Integer id);

}
