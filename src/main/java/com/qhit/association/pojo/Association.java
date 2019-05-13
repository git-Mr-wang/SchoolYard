package com.qhit.association.pojo;


/** 
* Created by GeneratorCode on 2019/05/09
*/ 

public class Association { 
    private Integer asId;    //社团——主键 
    private String asName;    //社团名字 
    private Integer userId;    //社长 
    private String describe;    //社团介绍 
    private String asLmage;    //图片 
    private Integer asLabel;    //标签 
    private Integer exaState;    //审核状态[1、审核中，2、已通过，null未审核，其他已驳回]
    private Integer pageSize;
    private Integer currentPage;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getAsId() {
        return asId;
    }

    public void setAsId(Integer asId) { 
        this.asId = asId;
    } 

    public String getAsName() { 
        return asName;
    }

    public void setAsName(String asName) { 
        this.asName = asName;
    }
    public Integer getUserId() { 
        return userId;
    }

    public void setUserId(Integer userId) { 
        this.userId = userId;
    } 

    public String getDescribe() { 
        return describe;
    }

    public void setDescribe(String describe) { 
        this.describe = describe;
    }
    public String getAsLmage() { 
        return asLmage;
    }

    public void setAsLmage(String asLmage) { 
        this.asLmage = asLmage;
    }
    public Integer getAsLabel() { 
        return asLabel;
    }

    public void setAsLabel(Integer asLabel) { 
        this.asLabel = asLabel;
    } 

    public Integer getExaState() { 
        return exaState;
    }

    public void setExaState(Integer exaState) { 
        this.exaState = exaState;
    } 


 }