package com.zcf.universe.pojo;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "user_lend")
public class UserLend {
    /**
     * 借款ID
     */
    @Column(name = "lend_id")
    private Integer lendId;

    @Column(name = "lend_user_id")
    private Integer lendUserId;

    @Column(name = "lend_price")
    private String lendPrice;

    /**
     * 借款状态:0待审核1.已通过2.未通过
     */
    @Column(name = "lend_status")
    private Integer lendStatus;

    /**
     * 还款状态：0未申请1.待款中2.已完成3.已逾期
     */
    @Column(name = "lend_repay_status")
    private Integer lendRepayStatus;

    /**
     * 获取借款ID
     *
     * @return lend_id - 借款ID
     */
    public Integer getLendId() {
        return lendId;
    }

    /**
     * 设置借款ID
     *
     * @param lendId 借款ID
     */
    public void setLendId(Integer lendId) {
        this.lendId = lendId;
    }

    /**
     * @return lend_user_id
     */
    public Integer getLendUserId() {
        return lendUserId;
    }

    /**
     * @param lendUserId
     */
    public void setLendUserId(Integer lendUserId) {
        this.lendUserId = lendUserId;
    }

    /**
     * @return lend_price
     */
    public String getLendPrice() {
        return lendPrice;
    }

    /**
     * @param lendPrice
     */
    public void setLendPrice(String lendPrice) {
        this.lendPrice = lendPrice;
    }

    /**
     * 获取借款状态:0待审核1.已通过2.未通过
     *
     * @return lend_status - 借款状态:0待审核1.已通过2.未通过
     */
    public Integer getLendStatus() {
        return lendStatus;
    }

    /**
     * 设置借款状态:0待审核1.已通过2.未通过
     *
     * @param lendStatus 借款状态:0待审核1.已通过2.未通过
     */
    public void setLendStatus(Integer lendStatus) {
        this.lendStatus = lendStatus;
    }

    /**
     * 获取还款状态：0未申请1.待款中2.已完成3.已逾期
     *
     * @return lend_repay_status - 还款状态：0未申请1.待款中2.已完成3.已逾期
     */
    public Integer getLendRepayStatus() {
        return lendRepayStatus;
    }

    /**
     * 设置还款状态：0未申请1.待款中2.已完成3.已逾期
     *
     * @param lendRepayStatus 还款状态：0未申请1.待款中2.已完成3.已逾期
     */
    public void setLendRepayStatus(Integer lendRepayStatus) {
        this.lendRepayStatus = lendRepayStatus;
    }
}