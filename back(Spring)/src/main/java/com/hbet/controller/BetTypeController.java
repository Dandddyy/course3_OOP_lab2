package com.hbet.controller;

import com.hbet.dto.*;
import com.hbet.service.BetTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/bet-type")
@RequiredArgsConstructor
public class BetTypeController {
    private final BetTypeService betTypeService;

    @GetMapping("/{id}")
    public ResponseEntity<BetTypeDTO> getBetType(@PathVariable Long id) {
        BetTypeDTO betType = betTypeService.getBetType(id);
        if (betType == null) {
            return ResponseEntity.notFound().build();
        }
        System.out.println(betType);
        return ResponseEntity.ok(betType);
    }

    @GetMapping
    public ResponseEntity<List<BetTypeDTO>> getBetTypes() {
        List<BetTypeDTO> betType = betTypeService.getBetTypes();
        if (betType == null) {
            return ResponseEntity.badRequest().build();
        }
        System.out.println(betType);
        return ResponseEntity.ok(betType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBetType(@PathVariable Long id,
            @RequestBody BetTypeDTO betTypeToUpdate
    ) {
        int updatedRows = betTypeService.updateBetType(id, betTypeToUpdate);
        if (updatedRows < 0) {
            return ResponseEntity.badRequest().build();
        } else if (updatedRows == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
