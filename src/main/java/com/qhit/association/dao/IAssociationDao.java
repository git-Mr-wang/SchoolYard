package com.qhit.association.dao;

import org.apache.ibatis.annotations.Mapper;
import com.qhit.association.pojo.Association;
import java.util.List;

/** 
* Created by GeneratorCode on 2019/05/09
*/

@Mapper  
public interface IAssociationDao {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object object);

    List freeFind(String sql);

    List findAll();

    List findById(Object id);

    boolean freeUpdate(String sql);

    List<Association> search(Association association);

    List findByAsName(Object asName);

    List findByUserId(Object userId);

    List findByDescribe(Object describe);

    List findByAsLmage(Object asLmage);

    List findByAsLabel(Object asLabel);

    List findByExaState(Object exaState);

}