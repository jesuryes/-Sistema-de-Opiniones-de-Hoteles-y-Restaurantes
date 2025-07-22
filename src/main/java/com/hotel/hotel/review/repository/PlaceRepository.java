package com.hotel.hotel.review.repository;

import com.hotel.hotel.review.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
