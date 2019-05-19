package com.qhit.baseUser.controller;

import com.alibaba.fastjson.JSON;
import com.qhit.baseUser.pojo.BaseUser;
import com.qhit.baseUser.service.IBaseUserService;
import com.qhit.utils.HttpUtil;
import com.qhit.utils.MD5;
import com.qhit.utils.RegexUtils;
import com.qhit.utils.SendEmail;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
* Created by GeneratorCode on 2018/12/10
*/ 

@RestController 
@RequestMapping("/baseUser") 
public class BaseUserController {

    @Resource
    IBaseUserService baseUserService;
    @Resource
    MD5 md5;
    @Resource
    RegexUtils regexUtils;
    @Resource
    HttpUtil httpUtil;

    @Resource
    SendEmail sendEmail;

    @RequestMapping("/insert")
    public boolean insert(BaseUser baseUser) {
        System.out.println(baseUser.toString());
        if (baseUser.getPassword()==null||baseUser.getTelno()==null){
            return false;
        }
        baseUser.setPassword(md5.getMD5ofStr(baseUser.getPassword()));
        boolean b = regexUtils.checkMobile(baseUser.getTelno());
        if (!b){
            return false;
        }
        String userName = baseUser.getUserName();
        for (int i = 0; i < userName.length(); i++) {
            boolean numeric = regexUtils.checkChinese(userName.charAt(i)+"");
            if (numeric){
                return false;
            }
        }
            baseUserService.insert(baseUser);
            return true;
    }

    @RequestMapping("/delete") 
    public void delete(Integer userid) { 
        baseUserService.delete(userid); 
    } 

    @RequestMapping("/update") 
    public void update(BaseUser baseUser) {
        baseUser.setPassword(md5.getMD5ofStr(baseUser.getPassword()));
        baseUserService.update(baseUser); 
    }

    int count=0;
    @RequestMapping("/login")
    public BaseUser login(BaseUser baseUser, HttpSession session) {

        if (baseUser.getPassword()!=null){
            baseUser.setPassword(md5.getMD5ofStr(baseUser.getPassword()));
            List<BaseUser> list = baseUserService.baseUserLogin(baseUser);
            if(list.size()>0){
                BaseUser user = list.get(0);
                JSONObject jsonObject = JSONObject.fromObject(user);
                String s = jsonObject.toString();
                session.setAttribute("baseUserLogin",s);
                count++;
                System.out.println("访问了"+count+"次");
                return user;
            }
        }
        return null;
    }

    //邮箱验证
    @RequestMapping("/emailVerification")
    public String emailVerification(String email) throws GeneralSecurityException {
        if (email==null||email==""){
            return "邮箱格式错误";
        }else {
            String ssendemail = sendEmail.ssendemail(email);
            return ssendemail;
        }
    }


    @RequestMapping("/updateSelective") 
    public void updateSelective(BaseUser baseUser) { 
        baseUserService.updateSelective(baseUser); 
    } 

    @RequestMapping("/load") 
    public BaseUser load(Integer userId) {
        BaseUser baseUser = baseUserService.findById(userId);
        return baseUser; 
    }

    @RequestMapping("/findByStatusId")
    public String findByStatusId(HttpSession session) {
        String str = (String) session.getAttribute("baseUserLogin");
        return str;
    }

    @RequestMapping("/list") 
    public List<BaseUser> list(HttpSession session)  {
//        String json = (String) session.getAttribute("baseUserLogin");
//        JSONObject jsonObject = JSONObject.fromObject(json);
//        Map mapTypes = (Map) JSON.parseObject(String.valueOf(jsonObject));
//        System.out.println("这个是用JSON类的parseObject来解析JSON字符串!!!");
//        if (mapTypes!=null){
//            for (Object obj : mapTypes.keySet()){
//                System.out.println("key为："+obj+"值为："+mapTypes.get(obj));
//            }
//        }
        List<BaseUser> list = baseUserService.findAll();
        return list;
    } 

    @RequestMapping("/search") 
    public List<BaseUser> search(BaseUser baseUser,HttpSession session,Integer pageSize,Integer currentPage) {
        int a = (currentPage-1)*5;
        baseUser.setPageSize(pageSize);
        baseUser.setCurrentPage(a);
        List<BaseUser> list = baseUserService.search(baseUser);
//        for (int i = 0; i < list.size(); i++) {
//            JSONObject jsonObject = JSONObject.fromObject(list.get(0));
//            Map map = (Map) JSON.parseObject(String.valueOf(jsonObject));
//            httpUtil.getForList("baseinfo","session/setSession",List.class,map);
//        }
//        for (BaseUser baseUser1:list){
//            System.out.println(baseUser1.toString());
//        }
        return list;
    } 

} 
