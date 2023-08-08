package com.wineApi.wine1.repositories;

import com.wineApi.wine1.models.Varietal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VarietalJpaRepository extends JpaRepository<Varietal, Long> {
}
