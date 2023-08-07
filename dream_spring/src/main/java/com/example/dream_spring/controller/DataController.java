package com.example.dream_spring.controller;

import com.example.dream_spring.model.Data;
import com.example.dream_spring.service.DataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
