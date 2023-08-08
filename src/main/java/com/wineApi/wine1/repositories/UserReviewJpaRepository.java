package com.wineApi.wine1.repositories;
import com.wineApi.wine1.models.UserReview;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserReviewJpaRepository extends JpaRepository<UserReview, Long> {
    List<UserReview> findUserReviewsByUserId(String userId);
    List<UserReview> findUserReviewsByWineId(String wineId);
}
