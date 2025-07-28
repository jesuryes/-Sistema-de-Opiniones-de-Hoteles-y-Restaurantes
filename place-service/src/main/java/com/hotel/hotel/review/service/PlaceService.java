package com.hotel.hotel.review.service;

import com.hotel.hotel.review.entity.Place;
import java.util.List;

public interface PlaceService {
    List<Place> getAll();
    Place getById(Long id);
    Place create(Place place);
    Place update(Long id, Place place);
    void delete(Long id);
}
