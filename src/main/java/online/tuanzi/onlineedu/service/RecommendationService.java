package online.tuanzi.onlineedu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import online.tuanzi.onlineedu.model.entity.Recommendation;

/**
* @author Tuanzi
* @description 针对表【recommendation】的数据库操作Service
* @createDate 2023-06-25 10:53:07
*/
public interface RecommendationService extends IService<Recommendation> {

    Recommendation getRecommendationById(int id);

    Recommendation createRecommendation(Recommendation recommendation);

    Recommendation updateRecommendation(int id, Recommendation recommendation);

    void deleteRecommendation(int id);
}
