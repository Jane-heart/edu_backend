package online.tuanzi.onlineedu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.tuanzi.onlineedu.model.entity.Advice;
import online.tuanzi.onlineedu.mapper.AdviceMapper;
import online.tuanzi.onlineedu.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【advice】的数据库操作Service实现
* @createDate 2023-06-25 10:53:07
*/
@Service
public class AdviceServiceImpl extends ServiceImpl<AdviceMapper, Advice>
    implements AdviceService {
    @Autowired
    private AdviceMapper adviceMapper;

    @Override
    public Advice getAdviceById(int id) {
        return adviceMapper.selectById(id);
    }

    @Override
    public Advice createAdvice(Advice advice) {
        adviceMapper.insert(advice);
        return advice;
    }

    @Override
    public Advice updateAdvice(int id, Advice advice) {
        advice.setId(id);
        adviceMapper.updateById(advice);
        return advice;
    }

    @Override
    public void deleteAdvice(int id) {
        adviceMapper.deleteById(id);
    }
}




