package com.zcf.universe.service;

import com.zcf.universe.pojo.MallBanner;
import com.zcf.universe.mapper.MallBannerMapper;
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
public class MallBannerService{

    @Autowired
    private MallBannerMapper mallBannermapper;

    //新增
    public void addMallBanner(MallBanner mallBanner) {
        boolean flag = this.mallBannermapper.insert(mallBanner) == 1;
        if(flag){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //删除
    public void deleteMallBanner(Integer id) {
        boolean flag = this.mallBannermapper.deleteByPrimaryKey(id) == 1;
        if(flag){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //更新
    public void updateMallBanner(MallBanner mallBanner) {
        boolean flag =this.mallBannermapper.updateByPrimaryKeySelective(mallBanner) == 1;
        if(flag){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //查询所有
    public List<MallBanner> getAllMallBanner() {
        List<MallBanner> list = this.mallBannermapper.selectAll();
       if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public MallBanner getMallBanner(Integer id){
        MallBanner MallBanner = this.mallBannermapper.selectByPrimaryKey(id);
        if (MallBanner == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return MallBanner;
    }

    //字段搜索
     public List<MallBanner> searchMallBanner(String keywords) {
        Example example = new Example(MallBanner.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        List<MallBanner> list = this.mallBannermapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }
}
