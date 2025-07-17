package com.megadiiiii.web.repository;

import com.megadiiiii.web.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClubRepository extends JpaRepository<Club, Long> {
    Optional<Club> findByTitle(String title);
    @Query("SELECT c from Club c where c.title like concat('%', :query, '%')")
    List<Club> searchClubs(String query);
}
