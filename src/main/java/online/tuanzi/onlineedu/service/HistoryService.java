package online.tuanzi.onlineedu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import online.tuanzi.onlineedu.model.entity.History;

/**
* @author Tuanzi
* @description 针对表【history】的数据库操作Service
* @createDate 2023-06-25 10:53:07
*/
public interface HistoryService extends IService<History> {

    History getHistoryById(int id);

    History createHistory(History history);

    History updateHistory(int id, History history);

    void deleteHistory(int id);
}
