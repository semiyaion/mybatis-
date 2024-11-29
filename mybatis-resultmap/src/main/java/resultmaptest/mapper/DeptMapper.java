package resultmaptest.mapper;

import org.apache.ibatis.annotations.Param;
import resultmaptest.pojo.Dept;

/**
 * @Classname DeptMapper
 * @Description TODO
 * @Date 2024/11/28 16:48
 * @Created by cxx
 */
public interface DeptMapper {
    //这是分布查询的第二步
    Dept getEmpandDepybysteptwo(@Param("deptId") Integer deptId);


    //查询部门以及部门中的员工信息
    Dept getDeptAndEmpbyDeptID(@Param("deptId") Integer deptId);

    //这是一对多查询的第一步
    Dept getEmpandDeptinfStepOne(@Param("deptId") Integer deptId);

}
