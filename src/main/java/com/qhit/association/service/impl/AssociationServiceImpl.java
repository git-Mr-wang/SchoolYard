package com.qhit.association.service.impl;

import com.qhit.association.service.IAssociationService;
import java.util.List;
import com.qhit.association.dao.IAssociationDao;
import com.qhit.association.pojo.Association;
import org.springframework.stereotype.Service;
import javax.annotation.Resource; 

/**
* Created by GeneratorCode on 2019/05/09
*/

@Service 
public class AssociationServiceImpl  implements IAssociationService {

    @Resource 
    IAssociationDao dao;

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
        Association association = findById(id); 
        return dao.delete(association); 
    } 

    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 

    @Override 
    public Association findById(Object id) { 
        List<Association> list = dao.findById(id); 
        return  list.get(0); 
    } 

    @Override 
    public List<Association> search(Association association) { 
        return dao.search(association); 
    } 

}