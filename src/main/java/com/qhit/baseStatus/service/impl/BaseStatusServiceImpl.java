package com.qhit.baseStatus.service.impl;

import com.qhit.baseStatus.service.IBaseStatusService;
import java.util.List;
import com.qhit.baseStatus.dao.IBaseStatusDao;
import com.qhit.baseStatus.pojo.BaseStatus;
import org.springframework.stereotype.Service;
import javax.annotation.Resource; 

/**
* Created by GeneratorCode on 2019/05/10
*/

@Service 
public class BaseStatusServiceImpl  implements IBaseStatusService {

    @Resource 
    IBaseStatusDao dao;

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
        BaseStatus baseStatus = findById(id); 
        return dao.delete(baseStatus); 
    } 

    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 

    @Override 
    public BaseStatus findById(Object id) { 
        List<BaseStatus> list = dao.findById(id); 
        return  list.get(0); 
    } 

    @Override 
    public List<BaseStatus> search(BaseStatus baseStatus) { 
        return dao.search(baseStatus); 
    } 

}