package com.megadiiiii.web.mapper;

import com.megadiiiii.web.dto.ClubDto;
import com.megadiiiii.web.models.Club;

import java.util.stream.Collectors;

import static com.megadiiiii.web.mapper.EventMapper.mapToEventDto;

public class ClubMapper {
    public static Club mapToClub (ClubDto club) {
        Club clubDto = Club.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .creationOn(club.getCreationOn())
                .updatedOn(club.getUpdatedOn())
                .build();
        return clubDto;
    }

    public static ClubDto mapToClubDto(Club club) {
        ClubDto clubDto = ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .creationOn(club.getCreationOn())
                .updatedOn(club.getUpdatedOn())
                .events(club.getEvents().stream().map(event -> mapToEventDto(event)).collect(Collectors.toList()))
                .build();
        return clubDto;
    }

}
