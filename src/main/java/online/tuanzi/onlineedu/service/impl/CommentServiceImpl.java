package online.tuanzi.onlineedu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.tuanzi.onlineedu.model.entity.Comment;
import online.tuanzi.onlineedu.mapper.CommentMapper;
import online.tuanzi.onlineedu.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【comment】的数据库操作Service实现
* @createDate 2023-06-25 10:53:07
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public Comment getCommentById(int id) {
        return commentMapper.selectById(id);
    }

    @Override
    public Comment createComment(Comment comment) {
        commentMapper.insert(comment);
        return comment;
    }

    @Override
    public Comment updateComment(int id, Comment comment) {
        comment.setId(id);
        commentMapper.updateById(comment);
        return comment;
    }

    @Override
    public void deleteComment(int id) {
        commentMapper.deleteById(id);
    }
}




