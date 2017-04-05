package org.springboot.sample.controller;

/**
 * Created by Alison on 2017/4/6.
 */

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springboot.sample.dao.IScoreDao;
import org.springboot.sample.entity.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/score")
public class ScoreController {

    private static final Logger logger = LoggerFactory.getLogger(ScoreController.class);

    @Autowired
    private IScoreDao scoreService;

    @RequestMapping("/scoreList")
    public List<Score> getScoreList(){
        logger.info("从数据库读取Score集合");
        // 测试更新数据库
        logger.info("更新的行数：" + scoreService.updateScoreById(88.8f, 2));
//        scoreService.delete(23);

        return scoreService.getList();
    }
}