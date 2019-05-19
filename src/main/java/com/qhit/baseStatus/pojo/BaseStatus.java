package com.qhit.baseStatus.pojo;


/** 
* Created by GeneratorCode on 2018/12/10
*/ 

public class BaseStatus { 
    private Integer statusId;    //主键 
    private String statusName;    //身份 

    public Integer getStatusId() { 
        return statusId;
    }

    public void setStatusId(Integer statusId) { 
        this.statusId = statusId;
    } 

    public String getStatusName() { 
        return statusName;
    }

    public void setStatusName(String statusName) { 
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "BaseStatus{" +
                "statusId=" + statusId +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}
