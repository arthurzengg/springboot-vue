/**
 * mapper 层：
 * 数据持久层，也被称为 dao 层
 * 作用是访问数据库，向数据库发送 sql 语句，完成数据的增删改查任务
 */
package com.example.dream_spring.mapper;

import com.example.dream_spring.model.Data;
import com.example.dream_spring.model.getUser;


import org.apache.ibatis.annotations.*;

import java.util.List;

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

    // 以下是添加功能
    //
    //
    //
    /**
     * 查询点赞数前50名的信息
     *
     * @return
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "province", column = "province"),
            @Result(property = "str", column = "str"),
            @Result(property = "likes", column = "likes")
    })
    @Select("select * from dream order by likes desc limit 50")
    List<getUser> findByLikes();

    /**
     * 查询最新的50条信息
     *
     * @return
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "province", column = "province"),
            @Result(property = "str", column = "str"),
            @Result(property = "likes", column = "likes")
    })
    @Select("select * from dream order by time desc limit 50")
    List<getUser> findByTime();

    /**
     * 查询随机的50条信息
     *
     * @return
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "province", column = "province"),
            @Result(property = "str", column = "str"),
            @Result(property = "likes", column = "likes")
    })
    @Select("select * from dream order by rand() limit 50")
    List<getUser> findByRand();

    /**
     * 更新指定id的点赞数+1
     *
     * @param id
     */
    @Update("update dream set likes=likes+1 where id=#{id}")
    void updateLikes(int id);

    /**
     * 更新指定id的点赞数-1
     *
     * @param id
     */
    @Update("update dream set likes=likes-1 where id=#{id}")
    void updateLikesJ(int id);

}