package com.zcf.project;

/**
 * @author yuan
 * @date 2018/11/15 0015
 */
public class ResultType {
    private String name;
    private String type;
    private String remark;

    public ResultType(String name, String type, String remark) {
        this.name = name;
        this.type = type;
        this.remark = remark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
