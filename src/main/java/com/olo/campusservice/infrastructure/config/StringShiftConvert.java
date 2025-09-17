package com.olo.campusservice.infrastructure.config;

import com.olo.campusservice.domain.model.enums.Shift;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringShiftConvert implements Converter<String, Shift> {
    @Override
    public Shift convert(String source) {
        return Shift.fromString(source);
    }
}