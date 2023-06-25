package online.tuanzi.onlineedu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.tuanzi.onlineedu.model.entity.Recommendation;
import online.tuanzi.onlineedu.mapper.RecommendationMapper;
import online.tuanzi.onlineedu.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【recommendation】的数据库操作Service实现
* @createDate 2023-06-25 10:53:07
*/
@Service
public class RecommendationServiceImpl extends ServiceImpl<RecommendationMapper, Recommendation>
    implements RecommendationService{

    @Autowired
    private RecommendationMapper recommendationMapper;

    @Override
    public Recommendation getRecommendationById(int id) {
        return recommendationMapper.selectById(id);
    }

    @Override
    public Recommendation createRecommendation(Recommendation recommendation) {
        recommendationMapper.insert(recommendation);
        return recommendation;
    }

    @Override
    public Recommendation updateRecommendation(int id, Recommendation recommendation) {
        recommendation.setId(id);
        recommendationMapper.updateById(recommendation);
        return recommendation;
    }

    @Override
    public void deleteRecommendation(int id) {
        recommendationMapper.deleteById(id);
    }
}




