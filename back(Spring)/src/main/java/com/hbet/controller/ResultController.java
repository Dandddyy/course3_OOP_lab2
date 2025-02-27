package com.hbet.controller;

import com.hbet.dto.ResultCreateDTO;
import com.hbet.dto.ResultDTO;
import com.hbet.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/result")
@RequiredArgsConstructor
public class ResultController {
    private final ResultService resultService;

    @PostMapping
    public ResponseEntity<ResultDTO> createResult(
            @RequestBody ResultCreateDTO resultToCreate
    ) {
        ResultDTO createdResult = resultService.createResult(resultToCreate);
        if (createdResult == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(createdResult);
    }
}
