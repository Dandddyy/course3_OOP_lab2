package com.hbet.service;

import com.hbet.dto.BetDTO;
import com.hbet.dto.BetTypeDTO;
import com.hbet.entity.Bet;
import com.hbet.entity.BetType;
import com.hbet.mapper.BetTypeMapper;
import com.hbet.repository.BetTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BetTypeService {
    private final BetTypeRepository betTypeRepository;
    private final BetTypeMapper mapper = BetTypeMapper.INSTANCE;

    public BetTypeDTO getBetType(Long id) {
        Optional<BetType> betType = betTypeRepository.findById(id);
        return betType.map(mapper::toBetTypeDTO).orElse(null);
    }

    public List<BetTypeDTO> getBetTypes() {
        List<BetType> betTypes = betTypeRepository.findAll();
        return betTypes.stream().map(mapper::toBetTypeDTO).toList();
    }

    public int updateBetType(Long id, BetTypeDTO betTypeToUpdate) {
        Optional<BetType> betTypeOptional = betTypeRepository.findById(id);
        if(betTypeOptional.isPresent()) {
            Optional<BetType> betType1 = betTypeRepository.findById(id);
            BetType betType2 = betType1.get();
            BetType betType = betTypeOptional.get();
            betType.setRaceId(betType2.getRaceId());
            betType.setHorseId(betType2.getHorseId());
            betType.setOdd(betTypeToUpdate.getOdd());
            betType.set_first(betType2.is_first());
            BetType updated = betTypeRepository.save(betType);
        }
        return betTypeOptional.isPresent() ? 1 : 0;
    }
}
