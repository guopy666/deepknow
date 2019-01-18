package com.gpy.deepdemo.controller;


import com.gpy.deepdemo.entity.Person;
import com.gpy.deepdemo.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author guopy
 * @since 2019-01-17
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private IPersonService personService;

    @RequestMapping("getpersonlist")
    @ResponseBody
    public List<Person> getPerson(){
        List<Person> personList = personService.list();
        return personList;
    }

}
