package online.tuanzi.onlineedu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import online.tuanzi.onlineedu.model.entity.Comment;

/**
* @author Tuanzi
* @description 针对表【comment】的数据库操作Service
* @createDate 2023-06-25 10:53:07
*/
public interface CommentService extends IService<Comment> {

    Comment getCommentById(int id);

    Comment createComment(Comment comment);

    Comment updateComment(int id, Comment comment);

    void deleteComment(int id);
}
