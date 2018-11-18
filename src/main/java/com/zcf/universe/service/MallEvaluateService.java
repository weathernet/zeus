package com.zcf.universe.service;

import com.zcf.universe.pojo.MallEvaluate;
import com.zcf.universe.mapper.MallEvaluateMapper;
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
public class MallEvaluateService{

    @Autowired
    private MallEvaluateMapper mallEvaluatemapper;

    //新增
    public void addMallEvaluate(MallEvaluate mallEvaluate) {
        boolean flag = this.mallEvaluatemapper.insert(mallEvaluate) == 1;
        if(flag){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //删除
    public void deleteMallEvaluate(Integer id) {
        boolean flag = this.mallEvaluatemapper.deleteByPrimaryKey(id) == 1;
        if(flag){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //更新
    public void updateMallEvaluate(MallEvaluate mallEvaluate) {
        boolean flag =this.mallEvaluatemapper.updateByPrimaryKeySelective(mallEvaluate) == 1;
        if(flag){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //查询所有
    public List<MallEvaluate> getAllMallEvaluate() {
        List<MallEvaluate> list = this.mallEvaluatemapper.selectAll();
       if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public MallEvaluate getMallEvaluate(Integer id){
        MallEvaluate MallEvaluate = this.mallEvaluatemapper.selectByPrimaryKey(id);
        if (MallEvaluate == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return MallEvaluate;
    }

    //字段搜索
     public List<MallEvaluate> searchMallEvaluate(String keywords) {
        Example example = new Example(MallEvaluate.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        List<MallEvaluate> list = this.mallEvaluatemapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }
}
