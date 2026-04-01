package com.training.bank_app_back.core.mapper;

import org.mapstruct.Mapper;

import java.math.BigDecimal;

@Mapper(componentModel = "spring")
public abstract class MappingUtils {

    public String enumToString(Enum<?> e) {
        return e != null ? e.name() : null;
    }

    public String bigDecimalToString(BigDecimal b) {
        return b != null ? b.toString() : null;
    }
}