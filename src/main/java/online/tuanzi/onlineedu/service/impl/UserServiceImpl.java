package online.tuanzi.onlineedu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.tuanzi.onlineedu.model.entity.User;
import online.tuanzi.onlineedu.mapper.UserMapper;
import online.tuanzi.onlineedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-06-25 10:53:07
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public User createUser(User user) {
        userMapper.insert(user);
        return user;
    }

    @Override
    public User updateUser(int id, User user) {
        user.setId(id);
        userMapper.updateById(user);
        return user;
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteById(id);
    }
}




