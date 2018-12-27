package com.zcf.universe.controller.console;

import com.zcf.universe.common.utils.LayUiResult;
import com.zcf.universe.pojo.HouseEvaluation;
import com.zcf.universe.service.LayUI.LayUiHouseEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YuanQJ
 * @date 2018/12/26
 */
@RestController
@RequestMapping("/house/evaluation")
public class LayUiHouseEvaluationController {

    @Autowired
    private LayUiHouseEvaluationService LayUihouseEvaluationservice;

    @RequestMapping("add")
    public boolean add(@RequestBody HouseEvaluation houseEvaluation) {
        return this.LayUihouseEvaluationservice.add(houseEvaluation);
    }

    @RequestMapping("delete")
    public boolean delete(@RequestParam Integer id) {
        return this.LayUihouseEvaluationservice.delete(id);
    }

    @RequestMapping("update")
    public boolean update(@RequestBody HouseEvaluation houseEvaluation) {
        return this.LayUihouseEvaluationservice.update(houseEvaluation);
    }

    @RequestMapping("query")
    public LayUiResult queryHouseEvaluation(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit) {
        return this.LayUihouseEvaluationservice.query(page, limit);
    }

    @RequestMapping("search")
    public LayUiResult search(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit,
                              @RequestParam String keywords) {
        return this.LayUihouseEvaluationservice.search(page, limit, keywords);
    }

}
