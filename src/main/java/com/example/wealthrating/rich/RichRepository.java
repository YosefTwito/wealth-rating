package com.example.wealthrating.rich;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RichRepository extends JpaRepository<Rich, Long> {

    Optional<Rich> findByIdentity(Long id);
}
