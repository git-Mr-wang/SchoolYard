package com.qhit.association.service;

import java.util.List;
import com.qhit.association.pojo.Association;
/**
* Created by GeneratorCode on 2018/12/09
*/
public interface IAssociationService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    Association findById(Object id);

    List<Association> search(Association association);

}
