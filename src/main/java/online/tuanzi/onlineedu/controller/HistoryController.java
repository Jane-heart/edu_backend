package online.tuanzi.onlineedu.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import online.tuanzi.onlineedu.model.entity.History;
import online.tuanzi.onlineedu.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/histories")
@Api(tags = "历史记录管理")
public class HistoryController {

  @Autowired
  private HistoryService historyService;

  @GetMapping("/{id}")
  @ApiOperation("根据ID获取历史记录信息")
  public History getHistoryById(@PathVariable int id) {
    return historyService.getHistoryById(id);
  }

  @PostMapping
  @ApiOperation("创建历史记录")
  public History createHistory(@RequestBody History history) {
    return historyService.createHistory(history);
  }

  @PutMapping("/{id}")
  @ApiOperation("更新历史记录信息")
  public History updateHistory(@PathVariable int id, @RequestBody History history) {
    return historyService.updateHistory(id, history);
  }

  @DeleteMapping("/{id}")
  @ApiOperation("删除历史记录")
  public void deleteHistory(@PathVariable int id) {
    historyService.deleteHistory(id);
  }
}