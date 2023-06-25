package online.tuanzi.onlineedu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import online.tuanzi.onlineedu.model.entity.Group;

/**
* @author Tuanzi
* @description 针对表【group】的数据库操作Service
* @createDate 2023-06-25 10:53:07
*/
public interface GroupService extends IService<Group> {

    Group getGroupById(int id);

    Group createGroup(Group group);

    Group updateGroup(int id, Group group);

    void deleteGroup(int id);
}
