package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.mapper.UserAddressMapper;
import com.zcf.universe.pojo.UserAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

/**
 * Created by YuanQJ on 2018/11/29.
 */
@Service
public class UserAddressService {

    @Autowired
    private UserAddressMapper userAddressmapper;

    //新增
    public void addUserAddress(UserAddress userAddress) {
        userAddress.setCreateTime(new Date());
        userAddress.setUpdateTime(new Date());
        int count = this.userAddressmapper.insertSelective(userAddress);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.SAVE_FAILURE);
        }
    }

    //删除
    public void deleteUserAddress(Integer id) {
        int count = this.userAddressmapper.deleteByPrimaryKey(id);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.DELETE_FAILURE);
        }
    }

    //获取当前用户的所有地址
    public List<UserAddress> getAllUserAddress(Integer userId) {
        Example example = new Example(UserAddress.class);
        example.createCriteria().andEqualTo("addressUserId", userId);
        List<UserAddress> userAddresses = this.userAddressmapper.selectByExample(example);
        if (CollectionUtils.isEmpty(userAddresses)) {
            throw new CommonException(ExceptionEnum.DATA_DOES_NOT_EXIST);
        }
        return userAddresses;
    }

    //更新
    public void updateUserAddress(UserAddress userAddress) {
        userAddress.setUpdateTime(new Date());
        int count = this.userAddressmapper.updateByPrimaryKeySelective(userAddress);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.UPDATE_FAILURE);
        }
    }


    //查询当前用户的默认地址
    public UserAddress getUserAddress(Integer userId) {
        //查询出当前用户所有的地址
        Example example = new Example(UserAddress.class);
        example.createCriteria().andEqualTo("addressUserId", userId).andEqualTo("addressDefault", 1);
        UserAddress UserAddress = this.userAddressmapper.selectOneByExample(example);
        if (UserAddress == null) {
            throw new CommonException(ExceptionEnum.THE_DEFAULT_ADDRESS_DOES_NOT_EXIST);
        }
        return UserAddress;
    }

    //选择地址
    public UserAddress selectUserAddress(Integer addressid, Integer userId) {
        //查询出当前用户所有的地址
        Example example = new Example(UserAddress.class);
        example.createCriteria().andEqualTo("addressUserId", userId);
        List<UserAddress> list = this.userAddressmapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.DATA_DOES_NOT_EXIST);
        }
        //并设置为未使用
        for (UserAddress aList : list) {
            aList.setAddressDefault(0);
            this.userAddressmapper.updateByPrimaryKey(aList);
        }
        //把当前传入的地址设置为默认
        UserAddress userAddress = this.userAddressmapper.selectByPrimaryKey(addressid);
        if (userAddress == null) {
            throw new CommonException(ExceptionEnum.DATA_DOES_NOT_EXIST);
        }
        userAddress.setAddressDefault(1);
        //更新状态
        int count = this.userAddressmapper.updateByPrimaryKey(userAddress);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.UPDATE_FAILURE);
        }
        return this.userAddressmapper.selectByPrimaryKey(addressid);

    }
}
