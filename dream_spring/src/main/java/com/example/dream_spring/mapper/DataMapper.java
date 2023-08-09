package com.example.dream_spring.mapper;

import com.example.dream_spring.model.Data;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DataMapper {

    /**
     * 信息来源IP地址
     * @param ip
     * 信息来源省份
     * @param province
     * 信息发出时间
     * @param time
     * 信息内容
     * @param str
     * 点赞数
     * @param likes
     *
     * @return
     */
    @Insert("insert into dream (ip, province, time, str, likes) values(#{ip}, #{province}, #{time}, #{str}, #{likes})")
    int insert(@Param("ip") String ip,
               @Param("province") String province,
               @Param("time") String time,
               @Param("str") String str,
               @Param("likes") int likes);

    /**
     * 信息id
     * @param id
     *
     * @return
     *
     * property属性对应Data对象中的成员名，column对应select出的字段名。
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "ip", column = "ip"),
            @Result(property = "province", column = "province"),
            @Result(property = "time", column = "time"),
            @Result(property = "str", column = "str"),
            @Result(property = "likes", column = "likes")
    })
    @Select("select * from dream where id = #{id}")
    Data findById(@Param("id") int id);

    /**
     * 用Data对象来作为传参,这样语句中的#{id}、#{ip}等数据就分别对应Data对象中的id和ip等属性。
     *
     * @param data
     */
    @Update("update dream set ip=#{ip}, province=#{province}, time=#{time}, str=#{str}, likes=#{likes} where id=#{id}")
    void update(Data data);

    /**
     * 删除该id对应的信息
     *
     * @param id
     */
    @Delete("delete from dream where id =#{id}")
    void delete(int id);

}