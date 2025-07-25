package com.megadiiiii.web.services;

import com.megadiiiii.web.dto.ClubDto;
import com.megadiiiii.web.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();

    Club saveClub(ClubDto clubDto);

    ClubDto findClubById(long clubId);

    void updateClub(ClubDto club);

    void deleteClub(long clubId);

    List<ClubDto> searchClubs(String query);
}
