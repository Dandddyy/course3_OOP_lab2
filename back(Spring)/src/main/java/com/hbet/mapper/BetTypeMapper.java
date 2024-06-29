package com.hbet.mapper;

import com.hbet.dto.BetCreateDTO;
import com.hbet.dto.BetDTO;
import com.hbet.dto.BetTypeDTO;
import com.hbet.dto.UserDTO;
import com.hbet.entity.Bet;
import com.hbet.entity.BetType;
import com.hbet.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BetTypeMapper {
    BetTypeMapper INSTANCE = Mappers.getMapper(BetTypeMapper.class);

    BetTypeDTO toBetTypeDTO(BetType betType);

}
