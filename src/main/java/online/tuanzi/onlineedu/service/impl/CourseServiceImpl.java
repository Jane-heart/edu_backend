package online.tuanzi.onlineedu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.tuanzi.onlineedu.model.entity.Course;
import online.tuanzi.onlineedu.mapper.CourseMapper;
import online.tuanzi.onlineedu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【course】的数据库操作Service实现
* @createDate 2023-06-25 10:53:07
*/
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course>
    implements CourseService{

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public Course getCourseById(int id) {
        return courseMapper.selectById(id);
    }

    @Override
    public Course createCourse(Course course) {
        courseMapper.insert(course);
        return course;
    }

    @Override
    public Course updateCourse(int id, Course course) {
        course.setId(id);
        courseMapper.updateById(course);
        return course;
    }

    @Override
    public void deleteCourse(int id) {
        courseMapper.deleteById(id);
    }
}




