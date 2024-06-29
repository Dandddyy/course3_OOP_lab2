package com.hbet.service;

import com.hbet.dto.RaceDTO;
import com.hbet.entity.Race;
import com.hbet.repository.RaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RaceService {
    private final RaceRepository raceRepository;

    public int updateRace(Long id, RaceDTO raceToUpdate) {
        Optional<Race> raceOptional = raceRepository.findById(id);
        if(raceOptional.isPresent()) {
            Race race = raceOptional.get();
            race.setStatus(raceToUpdate.getStatus());
            Race updated = raceRepository.save(race);
        }
        return raceOptional.isPresent() ? 1 : 0;
    }
}
