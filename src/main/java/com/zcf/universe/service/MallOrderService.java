package com.zcf.universe.service;

import com.zcf.universe.pojo.MallOrder;
import com.zcf.universe.mapper.MallOrderMapper;
import tk.mybatis.mapper.entity.Example;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import java.util.List;
/**
 * Created by YuanQJ on 2018/11/18.
 */
@Service
public class MallOrderService{

    @Autowired
    private MallOrderMapper mallOrdermapper;

    //新增
    public void addMallOrder(MallOrder mallOrder) {
        boolean flag = this.mallOrdermapper.insert(mallOrder) == 1;
        if(flag){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //删除
    public void deleteMallOrder(Integer id) {
        boolean flag = this.mallOrdermapper.deleteByPrimaryKey(id) == 1;
        if(flag){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //更新
    public void updateMallOrder(MallOrder mallOrder) {
        boolean flag =this.mallOrdermapper.updateByPrimaryKeySelective(mallOrder) == 1;
        if(flag){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //查询所有
    public List<MallOrder> getAllMallOrder() {
        List<MallOrder> list = this.mallOrdermapper.selectAll();
       if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public MallOrder getMallOrder(Integer id){
        MallOrder MallOrder = this.mallOrdermapper.selectByPrimaryKey(id);
        if (MallOrder == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return MallOrder;
    }

    //字段搜索
     public List<MallOrder> searchMallOrder(String keywords) {
        Example example = new Example(MallOrder.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        List<MallOrder> list = this.mallOrdermapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }
}
