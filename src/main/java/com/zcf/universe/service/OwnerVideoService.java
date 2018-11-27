package com.zcf.universe.service;

import com.zcf.universe.pojo.OwnerVideo;
import com.zcf.universe.mapper.OwnerVideoMapper;
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
public class OwnerVideoService{

    @Autowired
    private OwnerVideoMapper ownerVideomapper;

    //查询所有
    public List<OwnerVideo> getAllOwnerVideo() {
        List<OwnerVideo> list = this.ownerVideomapper.selectAll();
       if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public OwnerVideo getOwnerVideo(Integer id){
        OwnerVideo OwnerVideo = this.ownerVideomapper.selectByPrimaryKey(id);
        if (OwnerVideo == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return OwnerVideo;
    }

}
