package com.place.service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "places")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String type; // "HOTEL" o "RESTAURANT"
    private String description;
}
