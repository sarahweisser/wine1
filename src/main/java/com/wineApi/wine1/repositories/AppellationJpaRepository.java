package com.wineApi.wine1.repositories;

import com.wineApi.wine1.models.Appellation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppellationJpaRepository extends JpaRepository<Appellation, Long> {
}
