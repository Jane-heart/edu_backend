package online.tuanzi.onlineedu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.tuanzi.onlineedu.model.entity.Post;
import online.tuanzi.onlineedu.mapper.PostMapper;
import online.tuanzi.onlineedu.service.PostService;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【post】的数据库操作Service实现
* @createDate 2023-06-25 10:53:07
*/
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post>
    implements PostService{

}




