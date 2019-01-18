package com.gpy.deepdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author guopy
 * @since 2019-01-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *  自增主键id
     */
    @TableId(value = "person_id", type = IdType.AUTO)
    private Integer personId;

    /**
     * 名称
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别  1表示男性，2表示女性
     */
    private Integer gender;

    /**
     * 联系手机号
     */
    private String telphone;

    /**
     * 所在小组id
     */
    private Integer teamId;


}
