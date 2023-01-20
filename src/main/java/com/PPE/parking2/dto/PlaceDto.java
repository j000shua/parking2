package com.PPE.parking2.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Builder
public class PlaceDto {
    private String id;

    private String numero;
}
