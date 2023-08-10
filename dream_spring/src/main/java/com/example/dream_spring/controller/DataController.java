/**
 * controller 层：
 * 控制层
 * 作用是请求和响应控制
 * 负责前后端交互，接受前端请求，调用 service 层，接收 service 层返回的数据，最后返回具体的页面和数据到客户端
 */
package com.example.dream_spring.controller;

import com.example.dream_spring.model.Data;
import com.example.dream_spring.model.getUser;
import com.example.dream_spring.service.DataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(tags="API接口")
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class DataController {

    @Autowired
    private DataService dataService;

    @ApiOperation("添加完整信息")
    @PostMapping("/insert")
    public String insert(@RequestBody Data data) {
        // @RequestBody注解用来绑定通过http请求中application/json类型上传的数据

        return dataService.insert(data.getIp(), data.getProvince(), data.getTime(), data.getStr(), data.getLikes());
    }

    @ApiOperation("查询id对应的信息")
    @GetMapping("/findById/{id}")
    public Data findById(@PathVariable int id) {

        return dataService.findById(id);
    }

    @ApiOperation("更新信息")
    @PutMapping("/update")
    public void update(@RequestBody Data data) {

        dataService.update(data);
    }

    @ApiOperation("删除指定id的信息")
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id) {

        dataService.delete(id);
    }



    //以下为新添加接口
    //
    //
    @ApiOperation("上传信息接口")
    @PostMapping("/Add/{str}")
    public String Add(HttpServletRequest request, HttpServletResponse response, @PathVariable String str) {

        return dataService.Add(request, response, str);
    }

    @ApiOperation("查询点赞数前50名的信息")
    @GetMapping("/findByLikes")
    public List<getUser> findByLikes() {

        return dataService.findByLikes();
    }

    @ApiOperation("查询最新的50条信息")
    @GetMapping("/findByTime")
    public List<getUser> findByTime() {

        return dataService.findByTime();
    }

    @ApiOperation("查询随机的50条信息")
    @GetMapping("/findByRand")
    public List<getUser> findByRand() {

        return dataService.findByRand();
    }

    @ApiOperation("更新指定id对应的点赞数+1")
    @PutMapping("/updateLikes/{id}")
    public String updateLikes(@PathVariable int id) {

        return dataService.updateLikes(id);
    }

    @ApiOperation("更新指定id对应的点赞数-1")
    @PutMapping("/updateLikesJ/{id}")
    public String updateLikesJ(@PathVariable int id) {

        return dataService.updateLikesJ(id);
    }
}
