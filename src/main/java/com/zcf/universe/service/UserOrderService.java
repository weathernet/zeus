package com.zcf.universe.service;

import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import com.zcf.universe.mapper.UserOrderMapper;
import com.zcf.universe.pojo.UserOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by YuanQJ on 2018/11/08.
 */
@Service
public class UserOrderService {

    @Autowired
    private UserOrderMapper userOrdermapper;

    //新增
    public void addUserOrder(UserOrder userOrder) {
        int count = this.userOrdermapper.insert(userOrder) ;
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //删除
    public void deleteUserOrder(Integer id) {
        int count = this.userOrdermapper.deleteByPrimaryKey(id) ;
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //更新
    public void updateUserOrder(UserOrder userOrder) {
        int count = this.userOrdermapper.updateByPrimaryKeySelective(userOrder) ;
        if (count != 1) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //查询所有
    public List<UserOrder> getAllUserOrder() {
        List<UserOrder> list = this.userOrdermapper.selectAll();
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public UserOrder getUserOrder(Integer id) {
        UserOrder UserOrder = this.userOrdermapper.selectByPrimaryKey(id);
        if (UserOrder == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return UserOrder;
    }

    //字段搜索
    public List<UserOrder> searchUserOrder(String keywords) {
        Example example = new Example(UserOrder.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        List<UserOrder> list = this.userOrdermapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }
}
