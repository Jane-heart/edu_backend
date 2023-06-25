package online.tuanzi.onlineedu.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import online.tuanzi.onlineedu.model.entity.Comment;
import online.tuanzi.onlineedu.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/comments")
@Api(tags = "评论管理")
public class CommentController {

  @Autowired
  private CommentService commentService;

  @GetMapping("/{id}")
  @ApiOperation("根据ID获取评论信息")
  public Comment getCommentById(@PathVariable int id) {
    return commentService.getCommentById(id);
  }

  @PostMapping
  @ApiOperation("创建评论")
  public Comment createComment(@RequestBody Comment comment) {
    return commentService.createComment(comment);
  }

  @PutMapping("/{id}")
  @ApiOperation("更新评论信息")
  public Comment updateComment(@PathVariable int id, @RequestBody Comment comment) {
    return commentService.updateComment(id, comment);
  }

  @DeleteMapping("/{id}")
  @ApiOperation("删除评论")
  public void deleteComment(@PathVariable int id) {
    commentService.deleteComment(id);
  }
}