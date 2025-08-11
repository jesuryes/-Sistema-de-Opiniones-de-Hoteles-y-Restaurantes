package com.place.service.service;

import com.place.service.dto.PlaceDTO;
import com.place.service.model.Place;
import com.place.service.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaceService {
    private final PlaceRepository placeRepository;

    public List<PlaceDTO> getAll() {
        return placeRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Optional<PlaceDTO> getById(Long id) {
        return placeRepository.findById(id).map(this::toDTO);
    }

    public PlaceDTO create(PlaceDTO dto) {
        Place place = toEntity(dto);
        return toDTO(placeRepository.save(place));
    }

    public Optional<PlaceDTO> update(Long id, PlaceDTO dto) {
        return placeRepository.findById(id).map(existing -> {
            existing.setName(dto.getName());
            existing.setAddress(dto.getAddress());
            existing.setType(dto.getType());
            existing.setDescription(dto.getDescription());
            return toDTO(placeRepository.save(existing));
        });
    }

    public boolean delete(Long id) {
        if (placeRepository.existsById(id)) {
            placeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private PlaceDTO toDTO(Place place) {
        return PlaceDTO.builder()
                .id(place.getId())
                .name(place.getName())
                .address(place.getAddress())
                .type(place.getType())
                .description(place.getDescription())
                .build();
    }

    private Place toEntity(PlaceDTO dto) {
        return Place.builder()
                .id(dto.getId())
                .name(dto.getName())
                .address(dto.getAddress())
                .type(dto.getType())
                .description(dto.getDescription())
                .build();
    }
}
