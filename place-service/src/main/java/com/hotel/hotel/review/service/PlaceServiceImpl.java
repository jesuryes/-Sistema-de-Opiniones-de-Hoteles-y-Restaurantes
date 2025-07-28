package com.hotel.hotel.review.service;

import com.hotel.hotel.review.entity.Place;
import com.hotel.hotel.review.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    @Override
    public List<Place> getAll() {
        return placeRepository.findAll();
    }

    @Override
    public Place getById(Long id) {
        return placeRepository.findById(id).orElse(null);
    }

    @Override
    public Place create(Place place) {
        return placeRepository.save(place);
    }

    @Override
    public Place update(Long id, Place updatedPlace) {
        Optional<Place> optional = placeRepository.findById(id);
        if (optional.isPresent()) {
            Place place = optional.get();
            place.setNombre(updatedPlace.getNombre());
            place.setDireccion(updatedPlace.getDireccion());
            place.setTipo(updatedPlace.getTipo());
            place.setDescripcion(updatedPlace.getDescripcion());
            return placeRepository.save(place);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        placeRepository.deleteById(id);
    }
}
