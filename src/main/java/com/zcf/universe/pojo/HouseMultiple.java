package com.zcf.universe.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "house_multiple")
public class HouseMultiple {
    /**
     * 佣金比例ID
     */
    @Id
    @Column(name = "multiple_id")
    private Integer multipleId;

    /**
     * 佣金比例
     */
    @Column(name = "multiple_proportion")
    private Double multipleProportion;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "uptate_time")
    private Date uptateTime;

    /**
     * 获取佣金比例ID
     *
     * @return multiple_id - 佣金比例ID
     */
    public Integer getMultipleId() {
        return multipleId;
    }

    /**
     * 设置佣金比例ID
     *
     * @param multipleId 佣金比例ID
     */
    public void setMultipleId(Integer multipleId) {
        this.multipleId = multipleId;
    }

    /**
     * 获取佣金比例
     *
     * @return multiple_proportion - 佣金比例
     */
    public Double getMultipleProportion() {
        return multipleProportion;
    }

    /**
     * 设置佣金比例
     *
     * @param multipleProportion 佣金比例
     */
    public void setMultipleProportion(Double multipleProportion) {
        this.multipleProportion = multipleProportion;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return uptate_time - 更新时间
     */
    public Date getUptateTime() {
        return uptateTime;
    }

    /**
     * 设置更新时间
     *
     * @param uptateTime 更新时间
     */
    public void setUptateTime(Date uptateTime) {
        this.uptateTime = uptateTime;
    }
}