package com.example.AccountService.mapper;

import com.example.AccountService.dto.AccountDto;
import com.example.AccountService.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {

    AccountMapper MAPPER= Mappers.getMapper(AccountMapper.class);

    @Mapping(source = "accountId",target = "seqId")
    Account covertToEntity(AccountDto accountDto);

    @Mapping(source = "seqId",target = "accountId")
    AccountDto convertToDto(Account account);
}
