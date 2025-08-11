package com.place.service.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaceDTO {
    private Long id;
    private String name;
    private String address;
    private String type; // "HOTEL" o "RESTAURANT"
    private String description;
}
