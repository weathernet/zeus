package com.zcf.universe.service;

import com.zcf.universe.pojo.ServiceEvaluation;
import com.zcf.universe.mapper.ServiceEvaluationMapper;
import tk.mybatis.mapper.entity.Example;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import com.zcf.universe.common.exception.CommonException;
import com.zcf.universe.common.exception.ExceptionEnum;
import java.util.List;
/**
 * Created by YuanQJ on 2018/11/26.
 */
@Service
public class ServiceEvaluationService{

    @Autowired
    private ServiceEvaluationMapper serviceEvaluationmapper;

    //新增
    public void addServiceEvaluation(ServiceEvaluation serviceEvaluation) {
        int count = this.serviceEvaluationmapper.insert(serviceEvaluation);
        if(count != 1){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //删除
    public void deleteServiceEvaluation(Integer id) {
        int count = this.serviceEvaluationmapper.deleteByPrimaryKey(id);
        if(count != 1){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //更新
    public void updateServiceEvaluation(ServiceEvaluation serviceEvaluation) {
        int count = this.serviceEvaluationmapper.updateByPrimaryKeySelective(serviceEvaluation);
         if(count != 1){
             throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
    }

    //查询所有
    public List<ServiceEvaluation> getAllServiceEvaluation() {
        List<ServiceEvaluation> list = this.serviceEvaluationmapper.selectAll();
       if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }

    //查询单个
    public ServiceEvaluation getServiceEvaluation(Integer id){
        ServiceEvaluation ServiceEvaluation = this.serviceEvaluationmapper.selectByPrimaryKey(id);
        if (ServiceEvaluation == null) {
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return ServiceEvaluation;
    }

    //字段搜索
     public List<ServiceEvaluation> searchServiceEvaluation(String keywords) {
        Example example = new Example(ServiceEvaluation.class);
        example.createCriteria().andLike("name", "%" + keywords + "%");//name为你想要搜索的字段
        List<ServiceEvaluation> list = this.serviceEvaluationmapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            throw new CommonException(ExceptionEnum.HOUSE_LISTING_BE_REPEAT);
        }
        return list;
    }
}
