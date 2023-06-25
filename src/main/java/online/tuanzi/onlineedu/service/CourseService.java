package online.tuanzi.onlineedu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import online.tuanzi.onlineedu.model.entity.Course;

/**
* @author Tuanzi
* @description 针对表【course】的数据库操作Service
* @createDate 2023-06-25 10:53:07
*/
public interface CourseService extends IService<Course> {

    Course getCourseById(int id);

    Course createCourse(Course course);

    Course updateCourse(int id, Course course);

    void deleteCourse(int id);
}
