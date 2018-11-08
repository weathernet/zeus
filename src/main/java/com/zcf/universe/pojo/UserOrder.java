package com.zcf.universe.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "user_order")
public class UserOrder {
    /**
     * 订单号
     */
    @Id
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "order_user_id")
    private Integer orderUserId;

    /**
     * 状态:0房源订单1:商品订单
     */
    @Column(name = "order_type")
    private Integer orderType;

    /**
     * 商品ID
     */
    @Column(name = "order_goods_id")
    private Integer orderGoodsId;

    /**
     * 商品标题
     */
    @Column(name = "order_goods_title")
    private String orderGoodsTitle;

    /**
     * 商品照片
     */
    @Column(name = "order_goods_image")
    private String orderGoodsImage;

    /**
     * 商品价格
     */
    @Column(name = "order_goods_price")
    private String orderGoodsPrice;

    /**
     * 订单状态0.未付款1.待发货2待收货3待评价4已完成
     */
    @Column(name = "order_goods_status")
    private String orderGoodsStatus;

    /**
     * 收货人手机号
     */
    @Column(name = "order_user_phone")
    private String orderUserPhone;

    /**
     * 收货人地址
     */
    @Column(name = "order_user_address")
    private String orderUserAddress;

    /**
     * 快递公司
     */
    @Column(name = "order_courier_company")
    private String orderCourierCompany;

    /**
     * 快递单号
     */
    @Column(name = "order_courier_number")
    private String orderCourierNumber;

    /**
     * 房源Id
     */
    @Column(name = "order_housing_id")
    private Integer orderHousingId;

    @Column(name = "order_housing_title")
    private String orderHousingTitle;

    @Column(name = "order_housing_image")
    private String orderHousingImage;

    /**
     * 房屋合约结束时间
     */
    @Column(name = "order_housing_start_time")
    private String orderHousingStartTime;

    /**
     * 租房合约j结束时间
     */
    @Column(name = "order_housing_end_time")
    private String orderHousingEndTime;

    /**
     * 租金
     */
    @Column(name = "order_housing_price")
    private String orderHousingPrice;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取订单号
     *
     * @return order_id - 订单号
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 设置订单号
     *
     * @param orderId 订单号
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * @return order_user_id
     */
    public Integer getOrderUserId() {
        return orderUserId;
    }

    /**
     * @param orderUserId
     */
    public void setOrderUserId(Integer orderUserId) {
        this.orderUserId = orderUserId;
    }

    /**
     * 获取状态:0房源订单1:商品订单
     *
     * @return order_type - 状态:0房源订单1:商品订单
     */
    public Integer getOrderType() {
        return orderType;
    }

    /**
     * 设置状态:0房源订单1:商品订单
     *
     * @param orderType 状态:0房源订单1:商品订单
     */
    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    /**
     * 获取商品ID
     *
     * @return order_goods_id - 商品ID
     */
    public Integer getOrderGoodsId() {
        return orderGoodsId;
    }

    /**
     * 设置商品ID
     *
     * @param orderGoodsId 商品ID
     */
    public void setOrderGoodsId(Integer orderGoodsId) {
        this.orderGoodsId = orderGoodsId;
    }

    /**
     * 获取商品标题
     *
     * @return order_goods_title - 商品标题
     */
    public String getOrderGoodsTitle() {
        return orderGoodsTitle;
    }

    /**
     * 设置商品标题
     *
     * @param orderGoodsTitle 商品标题
     */
    public void setOrderGoodsTitle(String orderGoodsTitle) {
        this.orderGoodsTitle = orderGoodsTitle;
    }

    /**
     * 获取商品照片
     *
     * @return order_goods_image - 商品照片
     */
    public String getOrderGoodsImage() {
        return orderGoodsImage;
    }

    /**
     * 设置商品照片
     *
     * @param orderGoodsImage 商品照片
     */
    public void setOrderGoodsImage(String orderGoodsImage) {
        this.orderGoodsImage = orderGoodsImage;
    }

    /**
     * 获取商品价格
     *
     * @return order_goods_price - 商品价格
     */
    public String getOrderGoodsPrice() {
        return orderGoodsPrice;
    }

    /**
     * 设置商品价格
     *
     * @param orderGoodsPrice 商品价格
     */
    public void setOrderGoodsPrice(String orderGoodsPrice) {
        this.orderGoodsPrice = orderGoodsPrice;
    }

    /**
     * 获取订单状态0.未付款1.待发货2待收货3待评价4已完成
     *
     * @return order_goods_status - 订单状态0.未付款1.待发货2待收货3待评价4已完成
     */
    public String getOrderGoodsStatus() {
        return orderGoodsStatus;
    }

    /**
     * 设置订单状态0.未付款1.待发货2待收货3待评价4已完成
     *
     * @param orderGoodsStatus 订单状态0.未付款1.待发货2待收货3待评价4已完成
     */
    public void setOrderGoodsStatus(String orderGoodsStatus) {
        this.orderGoodsStatus = orderGoodsStatus;
    }

    /**
     * 获取收货人手机号
     *
     * @return order_user_phone - 收货人手机号
     */
    public String getOrderUserPhone() {
        return orderUserPhone;
    }

    /**
     * 设置收货人手机号
     *
     * @param orderUserPhone 收货人手机号
     */
    public void setOrderUserPhone(String orderUserPhone) {
        this.orderUserPhone = orderUserPhone;
    }

    /**
     * 获取收货人地址
     *
     * @return order_user_address - 收货人地址
     */
    public String getOrderUserAddress() {
        return orderUserAddress;
    }

    /**
     * 设置收货人地址
     *
     * @param orderUserAddress 收货人地址
     */
    public void setOrderUserAddress(String orderUserAddress) {
        this.orderUserAddress = orderUserAddress;
    }

    /**
     * 获取快递公司
     *
     * @return order_courier_company - 快递公司
     */
    public String getOrderCourierCompany() {
        return orderCourierCompany;
    }

    /**
     * 设置快递公司
     *
     * @param orderCourierCompany 快递公司
     */
    public void setOrderCourierCompany(String orderCourierCompany) {
        this.orderCourierCompany = orderCourierCompany;
    }

    /**
     * 获取快递单号
     *
     * @return order_courier_number - 快递单号
     */
    public String getOrderCourierNumber() {
        return orderCourierNumber;
    }

    /**
     * 设置快递单号
     *
     * @param orderCourierNumber 快递单号
     */
    public void setOrderCourierNumber(String orderCourierNumber) {
        this.orderCourierNumber = orderCourierNumber;
    }

    /**
     * 获取房源Id
     *
     * @return order_housing_id - 房源Id
     */
    public Integer getOrderHousingId() {
        return orderHousingId;
    }

    /**
     * 设置房源Id
     *
     * @param orderHousingId 房源Id
     */
    public void setOrderHousingId(Integer orderHousingId) {
        this.orderHousingId = orderHousingId;
    }

    /**
     * @return order_housing_title
     */
    public String getOrderHousingTitle() {
        return orderHousingTitle;
    }

    /**
     * @param orderHousingTitle
     */
    public void setOrderHousingTitle(String orderHousingTitle) {
        this.orderHousingTitle = orderHousingTitle;
    }

    /**
     * @return order_housing_image
     */
    public String getOrderHousingImage() {
        return orderHousingImage;
    }

    /**
     * @param orderHousingImage
     */
    public void setOrderHousingImage(String orderHousingImage) {
        this.orderHousingImage = orderHousingImage;
    }

    /**
     * 获取房屋合约结束时间
     *
     * @return order_housing_start_time - 房屋合约结束时间
     */
    public String getOrderHousingStartTime() {
        return orderHousingStartTime;
    }

    /**
     * 设置房屋合约结束时间
     *
     * @param orderHousingStartTime 房屋合约结束时间
     */
    public void setOrderHousingStartTime(String orderHousingStartTime) {
        this.orderHousingStartTime = orderHousingStartTime;
    }

    /**
     * 获取租房合约j结束时间
     *
     * @return order_housing_end_time - 租房合约j结束时间
     */
    public String getOrderHousingEndTime() {
        return orderHousingEndTime;
    }

    /**
     * 设置租房合约j结束时间
     *
     * @param orderHousingEndTime 租房合约j结束时间
     */
    public void setOrderHousingEndTime(String orderHousingEndTime) {
        this.orderHousingEndTime = orderHousingEndTime;
    }

    /**
     * 获取租金
     *
     * @return order_housing_price - 租金
     */
    public String getOrderHousingPrice() {
        return orderHousingPrice;
    }

    /**
     * 设置租金
     *
     * @param orderHousingPrice 租金
     */
    public void setOrderHousingPrice(String orderHousingPrice) {
        this.orderHousingPrice = orderHousingPrice;
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