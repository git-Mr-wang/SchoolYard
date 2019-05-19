package com.qhit.association.controller; 

import com.qhit.association.pojo.Association; 
import com.qhit.association.service.IAssociationService; 
import org.springframework.web.bind.annotation.RequestMapping; 
import javax.annotation.Resource; 
import java.util.List; 
import org.springframework.web.bind.annotation.RestController; 

/** 
* Created by GeneratorCode on 2018/12/09
*/ 

@RestController 
@RequestMapping("/association") 
public class AssociationController { 

    @Resource 
    IAssociationService associationService; 

    @RequestMapping("/insert") 
    public void insert(Association association) { 
        associationService.insert(association); 
    } 

    @RequestMapping("/delete") 
    public void delete(Integer asId) { 
        associationService.delete(asId); 
    } 

    @RequestMapping("/update") 
    public void update(Association association) { 
        associationService.update(association); 
    } 

    @RequestMapping("/updateSelective") 
    public void updateSelective(Association association) { 
        associationService.updateSelective(association); 
    } 

    @RequestMapping("/load") 
    public Association load(Integer asId) { 
        Association association = associationService.findById(asId); 
        return association; 
    } 

    @RequestMapping("/list") 
    public List<Association> list()  { 
        List<Association> list = associationService.findAll(); 
        return list; 
    } 

    @RequestMapping("/search") 
    public List<Association> search(Association association,Integer pageSize,Integer currentPage) {
        int a = (currentPage-1)*5;
        association.setPageSize(pageSize);
        association.setCurrentPage(a);
        List<Association> list = associationService.search(association); 
        return list; 
    } 

} 
