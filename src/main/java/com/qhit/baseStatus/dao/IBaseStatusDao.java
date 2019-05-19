package com.qhit.baseStatus.dao;

import org.apache.ibatis.annotations.Mapper;
import com.qhit.baseStatus.pojo.BaseStatus;
import java.util.List;

/** 
* Created by GeneratorCode on 2018/12/10
*/

@Mapper  
public interface IBaseStatusDao {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object object);

    List freeFind(String sql);

    List findAll();

    List findById(Object id);

    boolean freeUpdate(String sql);

    List<BaseStatus> search(BaseStatus baseStatus);

    List findByStatusName(Object statusName);

}
