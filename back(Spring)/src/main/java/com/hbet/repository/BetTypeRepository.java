package com.hbet.repository;

import com.hbet.entity.BetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetTypeRepository extends JpaRepository<BetType, Long> {
}
