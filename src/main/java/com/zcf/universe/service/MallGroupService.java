package com.zcf.universe.service;

import com.zcf.universe.pojo.MallGroup;
import com.zcf.universe.mapper.MallGroupMapper;
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
public class MallGroupService {

    @Autowired
    private MallGroupMapper mallGroupmapper;

    //新增
    public void addMallGroup(MallGroup mallGroup) {
        int count = this.mallGroupmapper.insertSelective(mallGroup);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.GOODS_LISTING_BE_REPEAT);
        }
    }

    //删除
    public void deleteMallGroup(Integer id) {
        int count = this.mallGroupmapper.deleteByPrimaryKey(id);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.GOODS_LISTING_BE_REPEAT);
        }
    }

    //更新
    public void updateMallGroup(MallGroup mallGroup) {
        int count = this.mallGroupmapper.updateByPrimaryKeySelective(mallGroup);
        if (count != 1) {
            throw new CommonException(ExceptionEnum.GOODS_LISTING_BE_REPEAT);
        }
    }

    //查询所有
    public List<MallGroup> getAllMallGroup() {
        List<MallGroup> list = this.mallGroupmapper.selectAll();
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.GOODS_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public MallGroup getMallGroup(Integer id) {
        MallGroup MallGroup = this.mallGroupmapper.selectByPrimaryKey(id);
        if (MallGroup == null) {
            throw new CommonException(ExceptionEnum.GOODS_LISTING_BE_REPEAT);
        }
        return MallGroup;
    }

    //字段搜索
    public List<MallGroup> searchMallGroupByHot() {
        Example example = new Example(MallGroup.class);
        example.createCriteria().andEqualTo("group_hot", "1");//name为你想要搜索的字段
        List<MallGroup> list = this.mallGroupmapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.GOODS_LISTING_BE_REPEAT);
        }
        return list;
    }

    //字段搜索
    public List<MallGroup> searchMallGroupById(Integer byid) {
        Example example = new Example(MallGroup.class);
        example.createCriteria().andEqualTo("group_by", byid.toString());//name为你想要搜索的字段
        List<MallGroup> list = this.mallGroupmapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.GOODS_LISTING_BE_REPEAT);
        }
        return list;
    }

    //字段搜索
    public List<MallGroup> searchMallGroup(String keywords) {
        Example example = new Example(MallGroup.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        List<MallGroup> list = this.mallGroupmapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(ExceptionEnum.GOODS_LISTING_BE_REPEAT);
        }
        return list;
    }
}
