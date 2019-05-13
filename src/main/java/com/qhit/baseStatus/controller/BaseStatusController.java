package com.qhit.baseStatus.controller; 

import com.qhit.baseStatus.pojo.BaseStatus; 
import com.qhit.baseStatus.service.IBaseStatusService; 
import org.springframework.web.bind.annotation.RequestMapping; 
import javax.annotation.Resource; 
import java.util.List; 
import org.springframework.web.bind.annotation.RestController; 

/** 
* Created by GeneratorCode on 2019/05/10
*/ 

@RestController 
@RequestMapping("/baseStatus") 
public class BaseStatusController { 

    @Resource 
    IBaseStatusService baseStatusService; 

    @RequestMapping("/insert") 
    public void insert(BaseStatus baseStatus) { 
        baseStatusService.insert(baseStatus); 
    } 

    @RequestMapping("/delete") 
    public void delete(Integer statusId) { 
        baseStatusService.delete(statusId); 
    } 

    @RequestMapping("/update") 
    public void update(BaseStatus baseStatus) { 
        baseStatusService.update(baseStatus); 
    } 

    @RequestMapping("/updateSelective") 
    public void updateSelective(BaseStatus baseStatus) { 
        baseStatusService.updateSelective(baseStatus); 
    } 

    @RequestMapping("/load") 
    public BaseStatus load(Integer statusId) { 
        BaseStatus baseStatus = baseStatusService.findById(statusId); 
        return baseStatus; 
    } 

    @RequestMapping("/list") 
    public List<BaseStatus> list()  { 
        List<BaseStatus> list = baseStatusService.findAll(); 
        return list; 
    } 

    @RequestMapping("/search") 
    public List<BaseStatus> search(BaseStatus baseStatus) { 
        List<BaseStatus> list = baseStatusService.search(baseStatus); 
        return list; 
    } 

} 
