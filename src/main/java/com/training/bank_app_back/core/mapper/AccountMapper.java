package com.training.bank_app_back.core.mapper;

import com.training.bank_app_back.core.dto.AccountDto;
import com.training.bank_app_back.core.entities.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = MappingUtils.class)
public interface AccountMapper extends BaseMapper<AccountDto, Account>{
    List<AccountDto> toDtoList(List<Account> entityList);
}

