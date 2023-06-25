package online.tuanzi.onlineedu.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import online.tuanzi.onlineedu.model.entity.Group;
import online.tuanzi.onlineedu.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/groups")
@Api(tags = "小组管理")
public class GroupController {

  @Autowired
  private GroupService groupService;

  @GetMapping("/{id}")
  @ApiOperation("根据ID获取小组信息")
  public Group getGroupById(@PathVariable int id) {
    return groupService.getGroupById(id);
  }

  @PostMapping
  @ApiOperation("创建小组")
  public Group createGroup(@RequestBody Group group) {
    return groupService.createGroup(group);
  }

  @PutMapping("/{id}")
  @ApiOperation("更新小组信息")
  public Group updateGroup(@PathVariable int id, @RequestBody Group group) {
    return groupService.updateGroup(id, group);
  }

  @DeleteMapping("/{id}")
  @ApiOperation("删除小组")
  public void deleteGroup(@PathVariable int id) {
    groupService.deleteGroup(id);
  }
}