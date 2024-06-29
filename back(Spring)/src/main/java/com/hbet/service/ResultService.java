package com.hbet.service;

import com.hbet.dto.ResultCreateDTO;
import com.hbet.dto.ResultDTO;
import com.hbet.entity.Result;
import com.hbet.mapper.ResultMapper;
import com.hbet.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResultService {
    private final ResultRepository resultRepository;
    private final ResultMapper mapper = ResultMapper.INSTANCE;
    public ResultDTO createResult(ResultCreateDTO resultCreateDTO) {
        Result result = mapper.fromResultCreate(resultCreateDTO);
        Result createdItem = resultRepository.save(result);
        return mapper.toResultDTO(createdItem);
    }
}
