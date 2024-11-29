package mybatisdemo.mapper;

import mybatisdemo.pojo.Emyloyeepojo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname Emyloyeemapper
 * @Description TODO
 * @Date 2024/11/28 13:53
 * @Created by cxx
 */
public interface Emyloyeemapper {
    //删除，修改，插入
    int deletebyid(Integer id);

    //根据员工id查询员工姓名
    String querynamebuid(Integer id);

    //根据员工id查工资
    Double querysalarybyid(Integer id);

    //查询工资高于传入值的员工姓名们200
    List<String> querynamesbysa(Double salary);

    //查询全部员工信息
    List<Emyloyeepojo> queryall();

    //批量删除
    int deleteemps(@Param("id") String id);

    List<Emyloyeepojo> getemp(@Param("tablename") String tablename);

    //添加用户信息，并获取自增主键
    void insertemp(Emyloyeepojo emyloyeepojo);
}
