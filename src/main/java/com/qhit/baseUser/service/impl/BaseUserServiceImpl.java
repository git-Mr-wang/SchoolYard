package com.qhit.baseUser.service.impl;

import com.qhit.baseUser.dao.IBaseUserDao;
import com.qhit.baseUser.pojo.BaseUser;
import com.qhit.baseUser.service.IBaseUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by GeneratorCode on 2018/12/10
*/

@Service 
public class BaseUserServiceImpl  implements IBaseUserService {

    @Resource
    IBaseUserDao dao;

    @Override 
    public boolean insert(Object object) { 
        return dao.insert(object); 
    } 

    @Override 
    public boolean update(Object object) { 
        return dao.update(object); 
    } 

    @Override 
    public boolean updateSelective(Object object) { 
        return dao.updateSelective(object); 
    } 

    @Override 
    public boolean delete(Object id) { 
        BaseUser baseUser = findById(id);
        return dao.delete(baseUser); 
    } 

    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 

    @Override 
    public BaseUser findById(Object id) {
        List<BaseUser> list = dao.findById(id);
        return  list.get(0); 
    } 

    @Override 
    public List<BaseUser> search(BaseUser baseUser) {
        return dao.search(baseUser);
    }

    @Override
    public List<BaseUser> baseUserLogin(BaseUser baseUser) {
        return dao.baseUserLogin(baseUser);
    }

}
