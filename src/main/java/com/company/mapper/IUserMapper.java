package com.company.mapper;

import com.company.dto.request.UsersaveDto;
import com.company.dto.request.UserupdateDto;
import com.company.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {
    IUserMapper INSTANCE= Mappers.getMapper(IUserMapper.class);
    User touser(final UsersaveDto dto);
    User touser(final UserupdateDto dto);
}
