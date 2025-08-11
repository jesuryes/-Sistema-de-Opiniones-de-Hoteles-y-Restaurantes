package com.place.service.controller;

import com.place.service.dto.PlaceDTO;
import com.place.service.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/places")
@RequiredArgsConstructor
public class PlaceController {
    private final PlaceService placeService;

    @GetMapping
    public List<PlaceDTO> getAll() {
        return placeService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaceDTO> getById(@PathVariable Long id) {
        return placeService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PlaceDTO> create(@RequestBody PlaceDTO dto) {
        return ResponseEntity.ok(placeService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlaceDTO> update(@PathVariable Long id, @RequestBody PlaceDTO dto) {
        return placeService.update(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return placeService.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
