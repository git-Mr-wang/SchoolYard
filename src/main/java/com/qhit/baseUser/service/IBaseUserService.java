package com.qhit.baseUser.service;

import com.qhit.baseUser.pojo.BaseUser;

import java.util.List;

/**
* Created by GeneratorCode on 2019/05/05
*/
public interface IBaseUserService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    BaseUser findById(Object id);

    List<BaseUser> search(BaseUser baseUser);

    List<BaseUser> baseUserLogin(BaseUser baseUser);
}