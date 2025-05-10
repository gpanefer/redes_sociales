package com.prometeus.redes_sociales.dto;

import lombok.Data;

@Data
public class TwitterResponseDto {
    private DataInner data;

    @Data
    public static class DataInner {
        private String id;
        private String name;
        private String username;
    }
}
