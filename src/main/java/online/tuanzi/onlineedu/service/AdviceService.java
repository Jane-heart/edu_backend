package online.tuanzi.onlineedu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import online.tuanzi.onlineedu.model.entity.Advice;

/**
* @author Tuanzi
* @description 针对表【advice】的数据库操作Service
* @createDate 2023-06-25 10:53:07
*/
public interface AdviceService extends IService<Advice> {

    Advice getAdviceById(int id);

    Advice createAdvice(Advice advice);

    Advice updateAdvice(int id, Advice advice);

    void deleteAdvice(int id);
}
