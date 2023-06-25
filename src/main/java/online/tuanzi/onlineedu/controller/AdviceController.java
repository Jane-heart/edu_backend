package online.tuanzi.onlineedu.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import online.tuanzi.onlineedu.model.entity.Advice;
import online.tuanzi.onlineedu.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/advices")
@Api(tags = "建议管理")
public class AdviceController {

  @Autowired
  private AdviceService adviceService;

  @GetMapping("/{id}")
  @ApiOperation("根据ID获取建议信息")
  public Advice getAdviceById(@PathVariable int id) {
    return adviceService.getAdviceById(id);
  }

  @PostMapping
  @ApiOperation("创建建议")
  public Advice createAdvice(@RequestBody Advice advice) {
    return adviceService.createAdvice(advice);
  }

  @PutMapping("/{id}")
  @ApiOperation("更新建议信息")
  public Advice updateAdvice(@PathVariable int id, @RequestBody Advice advice) {
    return adviceService.updateAdvice(id, advice);
  }

  @DeleteMapping("/{id}")
  @ApiOperation("删除建议")
  public void deleteAdvice(@PathVariable int id) {
    adviceService.deleteAdvice(id);
  }
}