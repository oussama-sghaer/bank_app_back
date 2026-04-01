package com.training.bank_app_back.core.mapper;

import org.mapstruct.Named;

import java.math.BigDecimal;
import java.util.List;

public interface BaseMapper <D,E>{
    D toDto(E entity);
    E toEntity(D dto);



}
