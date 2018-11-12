package com.zcf.universe.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "repair_menu")
public class RepairMenu {
    @Id
    @Column(name = "repair_id")
    private Integer repairId;

    /**
     * 父类名
     */
    @Column(name = "repair_name")
    private String repairName;

    /**
     * 图片
     */
    @Column(name = "repair_image")
    private String repairImage;

    /**
     * @return repair_id
     */
    public Integer getRepairId() {
        return repairId;
    }

    /**
     * @param repairId
     */
    public void setRepairId(Integer repairId) {
        this.repairId = repairId;
    }

    /**
     * 获取父类名
     *
     * @return repair_name - 父类名
     */
    public String getRepairName() {
        return repairName;
    }

    /**
     * 设置父类名
     *
     * @param repairName 父类名
     */
    public void setRepairName(String repairName) {
        this.repairName = repairName;
    }

    /**
     * 获取图片
     *
     * @return repair_image - 图片
     */
    public String getRepairImage() {
        return repairImage;
    }

    /**
     * 设置图片
     *
     * @param repairImage 图片
     */
    public void setRepairImage(String repairImage) {
        this.repairImage = repairImage;
    }
}