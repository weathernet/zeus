package com.zcf.universe.service;

import com.zcf.universe.pojo.OwnerNews;
import com.zcf.universe.mapper.OwnerNewsMapper;
import tk.mybatis.mapper.entity.Example;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import java.util.List;
/**
 * Created by YuanQJ on 2018/11/22.
 */
@Service
public class OwnerNewsService{

    @Autowired
    private OwnerNewsMapper ownerNewsmapper;

    //新增
    public void addOwnerNews(OwnerNews ownerNews) {
        int count = this.ownerNewsmapper.insert(ownerNews);
        if(count != 1){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //删除
    public void deleteOwnerNews(Integer id) {
        int count = this.ownerNewsmapper.deleteByPrimaryKey(id);
        if(count != 1){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //更新
    public void updateOwnerNews(OwnerNews ownerNews) {
        int count = this.ownerNewsmapper.updateByPrimaryKeySelective(ownerNews);
         if(count != 1){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //查询所有
    public List<OwnerNews> getAllOwnerNews() {
        List<OwnerNews> list = this.ownerNewsmapper.selectAll();
       if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public OwnerNews getOwnerNews(Integer id){
        OwnerNews OwnerNews = this.ownerNewsmapper.selectByPrimaryKey(id);
        if (OwnerNews == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return OwnerNews;
    }

    //字段搜索
     public List<OwnerNews> searchOwnerNews(String keywords) {
        Example example = new Example(OwnerNews.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        List<OwnerNews> list = this.ownerNewsmapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }
}
