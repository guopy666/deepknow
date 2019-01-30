package com.gpy.deepdemo.controller;


import com.gpy.deepdemo.entity.Person;
import com.gpy.deepdemo.service.IPersonService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author guopy
 * @since 2019-01-17
 */
//使用 RestController 注解，类中的方法不加 ResponseBody注解默认返回也是json形式字符串
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private IPersonService personService;

    @ApiOperation(value = "获取所有人",notes = "获取所有人列表", tags = "Person")
    @RequestMapping(value = "/getpersonlist", method = RequestMethod.GET)
    public List<Person> getPerson(){
        List<Person> personList = personService.list();
        return personList;
    }

    @RequestMapping(value = "/getpersonbyid/{personId}",method = RequestMethod.GET)
    @ApiOperation(value = "根据ID获取人员信息", notes = "根据ID获取人员信息", tags = "Person")
    @ApiImplicitParams({
            @ApiImplicitParam(name="personId",value = "人员Id", paramType = "path",required = true, dataType = "Integer")
    })
    public Person getPersonById(@PathVariable("personId") Integer personId){
        Person person = personService.getById(personId);
        return person;
    }
}