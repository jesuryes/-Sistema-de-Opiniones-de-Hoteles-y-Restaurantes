package com.hotel.hotel.review.controller;

import com.hotel.hotel.review.entity.Place;
import com.hotel.hotel.review.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/places")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @GetMapping
    public List<Place> getAll() {
        return placeService.getAll();
    }

    @GetMapping("/{id}")
    public Place getById(@PathVariable Long id) {
        return placeService.getById(id);
    }

    @PostMapping
    public Place create(@RequestBody Place place) {
        return placeService.create(place);
    }

    @PutMapping("/{id}")
    public Place update(@PathVariable Long id, @RequestBody Place place) {
        return placeService.update(id, place);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        placeService.delete(id);
    }
}
