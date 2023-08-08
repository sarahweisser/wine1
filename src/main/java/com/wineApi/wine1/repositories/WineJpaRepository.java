package com.wineApi.wine1.repositories;

import com.wineApi.wine1.models.Wine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WineJpaRepository extends JpaRepository<Wine, Long> {
    Iterable<Wine> findWineByWineName(String wineNane);
}
