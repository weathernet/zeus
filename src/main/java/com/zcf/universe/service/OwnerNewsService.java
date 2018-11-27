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

}
