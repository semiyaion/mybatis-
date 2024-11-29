package testcache.mapper;

import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import testcache.pojo.Emp;

/**
 * @Classname EmpMapper
 * @Description TODO
 * @Date 2024/11/29 10:44
 * @Created by cxx
 */
public interface EmpMapper {
    Emp getEmpbyid(@Param("empid") Integer empid);
}
