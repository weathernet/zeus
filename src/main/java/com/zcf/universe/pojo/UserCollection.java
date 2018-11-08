package com.zcf.universe.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "user_collection")
public class UserCollection {
    @Id
    @Column(name = "collection_id")
    private Integer collectionId;

    @Column(name = "collection_user_id")
    private String collectionUserId;

    @Column(name = "collection_housing_id")
    private Integer collectionHousingId;

    @Column(name = "collection_housing_image")
    private String collectionHousingImage;

    @Column(name = "collection_housing_price")
    private BigDecimal collectionHousingPrice;

    @Column(name = "collection_housing_title")
    private String collectionHousingTitle;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return collection_id
     */
    public Integer getCollectionId() {
        return collectionId;
    }

    /**
     * @param collectionId
     */
    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    /**
     * @return collection_user_id
     */
    public String getCollectionUserId() {
        return collectionUserId;
    }

    /**
     * @param collectionUserId
     */
    public void setCollectionUserId(String collectionUserId) {
        this.collectionUserId = collectionUserId;
    }

    /**
     * @return collection_housing_id
     */
    public Integer getCollectionHousingId() {
        return collectionHousingId;
    }

    /**
     * @param collectionHousingId
     */
    public void setCollectionHousingId(Integer collectionHousingId) {
        this.collectionHousingId = collectionHousingId;
    }

    /**
     * @return collection_housing_image
     */
    public String getCollectionHousingImage() {
        return collectionHousingImage;
    }

    /**
     * @param collectionHousingImage
     */
    public void setCollectionHousingImage(String collectionHousingImage) {
        this.collectionHousingImage = collectionHousingImage;
    }

    /**
     * @return collection_housing_price
     */
    public BigDecimal getCollectionHousingPrice() {
        return collectionHousingPrice;
    }

    /**
     * @param collectionHousingPrice
     */
    public void setCollectionHousingPrice(BigDecimal collectionHousingPrice) {
        this.collectionHousingPrice = collectionHousingPrice;
    }

    /**
     * @return collection_housing_title
     */
    public String getCollectionHousingTitle() {
        return collectionHousingTitle;
    }

    /**
     * @param collectionHousingTitle
     */
    public void setCollectionHousingTitle(String collectionHousingTitle) {
        this.collectionHousingTitle = collectionHousingTitle;
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