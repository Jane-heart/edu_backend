package online.tuanzi.onlineedu.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import online.tuanzi.onlineedu.model.entity.Course;
import online.tuanzi.onlineedu.model.entity.History;
import online.tuanzi.onlineedu.model.entity.Recommendation;
import online.tuanzi.onlineedu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/courses")
@Api(tags = "课程管理")
public class CourseController {

  @Autowired
  private CourseService courseService;

  @GetMapping("/{id}")
  @ApiOperation("根据ID获取课程信息")
  public Course getCourseById(@PathVariable int id) {
    return courseService.getCourseById(id);
  }

  @PostMapping
  @ApiOperation("创建课程")
  public Course createCourse(@RequestBody Course course) {
    return courseService.createCourse(course);
  }

  @PutMapping("/{id}")
  @ApiOperation("更新课程信息")
  public Course updateCourse(@PathVariable int id, @RequestBody Course course) {
    return courseService.updateCourse(id, course);
  }

  @DeleteMapping("/{id}")
  @ApiOperation("删除课程")
  public void deleteCourse(@PathVariable int id) {
    courseService.deleteCourse(id);
  }
}