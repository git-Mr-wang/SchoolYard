package com.qhit.baseStatus.service;

import java.util.List;
import com.qhit.baseStatus.pojo.BaseStatus;
/**
* Created by GeneratorCode on 2018/12/10
*/
public interface IBaseStatusService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    BaseStatus findById(Object id);

    List<BaseStatus> search(BaseStatus baseStatus);

}
