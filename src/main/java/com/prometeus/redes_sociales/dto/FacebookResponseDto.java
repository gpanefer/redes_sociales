package com.prometeus.redes_sociales.dto;

import lombok.Data;

@Data
public class FacebookResponseDto {
    private String id;
    private String name;
    private String email;
    private Picture picture;

    @Data
    public static class Picture {
        private DataInner data;
    }

    @Data
    public static class DataInner {
        private String url;
    }
}
