package com.gpy.deepdemo.service.impl;

import com.gpy.deepdemo.entity.Person;
import com.gpy.deepdemo.dao.PersonDao;
import com.gpy.deepdemo.service.IPersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author guopy
 * @since 2019-01-17
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonDao, Person> implements IPersonService {

}
