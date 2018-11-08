package com.zcf.universe.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "user_vip")
public class UserVip {
    /**
     * 会员ID
     */
    @Id
    @Column(name = "vip_id")
    private Integer vipId;

    /**
     * 会员名称
     */
    @Column(name = "vip_name")
    private String vipName;

    /**
     * 会员折扣
     */
    @Column(name = "vip_discount")
    private String vipDiscount;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取会员ID
     *
     * @return vip_id - 会员ID
     */
    public Integer getVipId() {
        return vipId;
    }

    /**
     * 设置会员ID
     *
     * @param vipId 会员ID
     */
    public void setVipId(Integer vipId) {
        this.vipId = vipId;
    }

    /**
     * 获取会员名称
     *
     * @return vip_name - 会员名称
     */
    public String getVipName() {
        return vipName;
    }

    /**
     * 设置会员名称
     *
     * @param vipName 会员名称
     */
    public void setVipName(String vipName) {
        this.vipName = vipName;
    }

    /**
     * 获取会员折扣
     *
     * @return vip_discount - 会员折扣
     */
    public String getVipDiscount() {
        return vipDiscount;
    }

    /**
     * 设置会员折扣
     *
     * @param vipDiscount 会员折扣
     */
    public void setVipDiscount(String vipDiscount) {
        this.vipDiscount = vipDiscount;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}