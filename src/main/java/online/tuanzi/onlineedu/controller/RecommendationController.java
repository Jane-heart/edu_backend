package online.tuanzi.onlineedu.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import online.tuanzi.onlineedu.model.entity.Recommendation;
import online.tuanzi.onlineedu.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/recommendations")
@Api(tags = "推荐管理")
public class RecommendationController {

  @Autowired
  private RecommendationService recommendationService;

  @GetMapping("/{id}")
  @ApiOperation("根据ID获取推荐信息")
  public Recommendation getRecommendationById(@PathVariable int id) {
    return recommendationService.getRecommendationById(id);
  }

  @PostMapping
  @ApiOperation("创建推荐")
  public Recommendation createRecommendation(@RequestBody Recommendation recommendation) {
    return recommendationService.createRecommendation(recommendation);
  }

  @PutMapping("/{id}")
  @ApiOperation("更新推荐信息")
  public Recommendation updateRecommendation(@PathVariable int id, @RequestBody Recommendation recommendation) {
    return recommendationService.updateRecommendation(id, recommendation);
  }

  @DeleteMapping("/{id}")
  @ApiOperation("删除推荐")
  public void deleteRecommendation(@PathVariable int id) {
    recommendationService.deleteRecommendation(id);
  }
}