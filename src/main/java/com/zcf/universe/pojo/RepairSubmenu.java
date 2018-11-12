package com.zcf.universe.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "repair_submenu")
public class RepairSubmenu {
    /**
     * 子菜单主键
     */
    @Id
    @Column(name = "repair_sub_id")
    private Integer repairSubId;

    /**
     * 父菜单主键
     */
    @Column(name = "repair_menu_id")
    private Integer repairMenuId;

    /**
     * 子菜单名称
     */
    @Column(name = "repair_sub_name")
    private String repairSubName;

    /**
     * 子菜单的图片
     */
    @Column(name = "repair_sub_image")
    private String repairSubImage;

    /**
     * 获取子菜单主键
     *
     * @return repair_sub_id - 子菜单主键
     */
    public Integer getRepairSubId() {
        return repairSubId;
    }

    /**
     * 设置子菜单主键
     *
     * @param repairSubId 子菜单主键
     */
    public void setRepairSubId(Integer repairSubId) {
        this.repairSubId = repairSubId;
    }

    /**
     * 获取父菜单主键
     *
     * @return repair_menu_id - 父菜单主键
     */
    public Integer getRepairMenuId() {
        return repairMenuId;
    }

    /**
     * 设置父菜单主键
     *
     * @param repairMenuId 父菜单主键
     */
    public void setRepairMenuId(Integer repairMenuId) {
        this.repairMenuId = repairMenuId;
    }

    /**
     * 获取子菜单名称
     *
     * @return repair_sub_name - 子菜单名称
     */
    public String getRepairSubName() {
        return repairSubName;
    }

    /**
     * 设置子菜单名称
     *
     * @param repairSubName 子菜单名称
     */
    public void setRepairSubName(String repairSubName) {
        this.repairSubName = repairSubName;
    }

    /**
     * 获取子菜单的图片
     *
     * @return repair_sub_image - 子菜单的图片
     */
    public String getRepairSubImage() {
        return repairSubImage;
    }

    /**
     * 设置子菜单的图片
     *
     * @param repairSubImage 子菜单的图片
     */
    public void setRepairSubImage(String repairSubImage) {
        this.repairSubImage = repairSubImage;
    }
}