/**
 * service 层：
 * 业务逻辑层
 * 作用是完成功能设计
 * 调用 mapper 层接口，接收 mapper 层返回的数据，完成项目的基本功能设计
 */
package com.example.dream_spring.service;
import com.example.dream_spring.mapper.DataMapper;
import com.example.dream_spring.model.Data;
import com.example.dream_spring.model.getUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class DataService {
    @Autowired
    private DataMapper dataMapper;

    /**
     * 新增信息
     *
     * @param ip
     * @param province
     * @param time
     * @param str
     * @param likes
     * @return
     */
    public String insert(String ip, String province, String time, String str, int likes) {
        dataMapper.insert( ip, province, time, str, likes);
        return "succeed";
    }

    /**
     * 查询id对应的信息
     *
     * @param id
     * @return
     */
    public Data findById(int id) {
        return dataMapper.findById(id);
    }

    /**
     * 更新信息
     *
     * @param data
     */
    public void update(Data data) {
        dataMapper.update(data);
    }

    /**
     * 删除id对应的信息
     *
     * @param id
     */
    public void delete(int id) {
        dataMapper.delete(id);
    }



    //以下是新添加内容
    //
    //
    /**
     * 获取用户数据并调用mapper层上传数据库
     *
     * @param request
     * @param response
     * @param str
     * @return
     */
    public String Add(HttpServletRequest request, HttpServletResponse response, String str) {

        getIP getIP = new getIP();
        getProvince getProvince = new getProvince();
        getTime getTime = new getTime();

        //获取信息的IP地址
        String ip = getIP.getIP_(request, response);
        //ip="43.140.244.82";
        //获取信息所属省份
        String province = getProvince.getProvince_(ip);
        //获取当前时间
        String time = getTime.getTime_();
        //设置点赞数为0
        int likes = 0;

        //上传数据
        dataMapper.insert(ip, province, time, str, likes);

        return "succeed";
    }

    /**
     * 查询点赞数排名前50的信息
     *
     * @return
     */
    public List<getUser> findByLikes() {
        return dataMapper.findByLikes();
    }

    /**
     * 查询最新的50条信息
     *
     * @return
     */
    public List<getUser> findByTime() {
        return dataMapper.findByTime();
    }

    /**
     * 查询随机的50条信息
     *
     * @return
     */
    public List<getUser> findByRand() {
        return dataMapper.findByRand();
    }

    /**
     * 更新指定id对应的点赞数+1
     *
     * @param id
     * @return
     */
    public String updateLikes(int id) {
        dataMapper.updateLikes(id);

        return "succeed";
    }

    /**
     * 更新指定id对应的点赞数-1
     *
     * @param id
     * @return
     */
    public String updateLikesJ(int id) {
        dataMapper.updateLikesJ(id);

        return "succeed";
    }

}
