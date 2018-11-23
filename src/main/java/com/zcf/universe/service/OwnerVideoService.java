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

    //新增
    public void addOwnerVideo(OwnerVideo ownerVideo) {
        int count = this.ownerVideomapper.insert(ownerVideo);
        if(count != 1){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //删除
    public void deleteOwnerVideo(Integer id) {
        int count = this.ownerVideomapper.deleteByPrimaryKey(id);
        if(count != 1){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //更新
    public void updateOwnerVideo(OwnerVideo ownerVideo) {
        int count = this.ownerVideomapper.updateByPrimaryKeySelective(ownerVideo);
         if(count != 1){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

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

    //字段搜索
     public List<OwnerVideo> searchOwnerVideo(String keywords) {
        Example example = new Example(OwnerVideo.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        List<OwnerVideo> list = this.ownerVideomapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }
}
