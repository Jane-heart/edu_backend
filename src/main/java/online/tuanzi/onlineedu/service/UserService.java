package online.tuanzi.onlineedu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import online.tuanzi.onlineedu.model.entity.User;

/**
* @author Tuanzi
* @description 针对表【user】的数据库操作Service
* @createDate 2023-06-25 10:53:07
*/
public interface UserService extends IService<User> {

    User getUserById(int id);

    User createUser(User user);

    User updateUser(int id, User user);

    void deleteUser(int id);
}
