package com.gpy.deepdemo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description:
 * @author: guopy
 * @Date: 2019/6/14 16:15
 * @version: v1.0.0
 */
@Data
@Accessors(chain = true)
public class Aaa {
    private Integer id;
    private String age;
    private Boolean sex;
}