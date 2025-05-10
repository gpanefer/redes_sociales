package com.prometeus.redes_sociales.dto;

import lombok.Data;

@Data
public class InstagramResponseDto {
    private String id;
    private String username;
    private String account_type;
    private Integer media_count;
}
