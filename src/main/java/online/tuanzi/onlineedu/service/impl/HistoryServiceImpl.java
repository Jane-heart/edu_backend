package online.tuanzi.onlineedu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.tuanzi.onlineedu.model.entity.History;
import online.tuanzi.onlineedu.mapper.HistoryMapper;
import online.tuanzi.onlineedu.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【history】的数据库操作Service实现
* @createDate 2023-06-25 10:53:07
*/
@Service
public class HistoryServiceImpl extends ServiceImpl<HistoryMapper, History>
    implements HistoryService{

    @Autowired
    private HistoryMapper historyMapper;

    @Override
    public History getHistoryById(int id) {
        return historyMapper.selectById(id);
    }

    @Override
    public History createHistory(History history) {
        historyMapper.insert(history);
        return history;
    }

    @Override
    public History updateHistory(int id, History history) {
        history.setId(id);
        historyMapper.updateById(history);
        return history;
    }

    @Override
    public void deleteHistory(int id) {
        historyMapper.deleteById(id);
    }
}




