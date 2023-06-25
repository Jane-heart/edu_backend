package online.tuanzi.onlineedu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.tuanzi.onlineedu.model.entity.Group;
import online.tuanzi.onlineedu.mapper.GroupMapper;
import online.tuanzi.onlineedu.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【group】的数据库操作Service实现
* @createDate 2023-06-25 10:53:07
*/
@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Group>
    implements GroupService{
    @Autowired
    private GroupMapper groupMapper;

    @Override
    public Group getGroupById(int id) {
        return groupMapper.selectById(id);
    }

    @Override
    public Group createGroup(Group group) {
        groupMapper.insert(group);
        return group;
    }

    @Override
    public Group updateGroup(int id, Group group) {
        group.setId(id);
        groupMapper.updateById(group);
        return group;
    }

    @Override
    public void deleteGroup(int id) {
        groupMapper.deleteById(id);
    }
}




