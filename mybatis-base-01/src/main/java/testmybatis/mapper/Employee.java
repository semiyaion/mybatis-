package testmybatis.mapper;

import testmybatis.pojo.Emyloyeepojo;

public interface Employee {
    Emyloyeepojo querybyid(Integer id);

    int delbyid(Integer id);


}
