package com.ars.shortener.repository;

import com.ars.shortener.entity.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<UrlEntity, Long> {
    boolean existsByShortCode(String shortCode);

    Optional<UrlEntity> findByShortCode(String shortCode);
}
