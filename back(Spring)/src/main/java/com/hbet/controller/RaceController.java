package com.hbet.controller;

import com.hbet.dto.RaceDTO;
import com.hbet.service.RaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/race")
@RequiredArgsConstructor
public class RaceController {
    private final RaceService raceService;

    @PutMapping("/{id}")
    public ResponseEntity<String> updateRace(@PathVariable Long id,
                                             @RequestBody RaceDTO raceToUpdate
    ) {
        int updatedRows = raceService.updateRace(id, raceToUpdate);
        if (updatedRows < 0) {
            return ResponseEntity.badRequest().build();
        } else if (updatedRows == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("{\"message\": \"Bet updated successfully\"}");
    }
}
