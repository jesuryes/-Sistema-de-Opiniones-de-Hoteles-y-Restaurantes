package com.hotel.review.service;

import java.util.List;
import com.hotel.review.model.Review;

public interface ReviewService {
    Review createReview(Review review);
    Review getReviewById(Long id);
    List<Review> getAllReviews();
    List<Review> getReviewsByPlaceId(Long placeId);
    List<Review> getReviewsByUserId(Long userId);
    List<Review> getReviewsByMinRating(Integer rating);
    Review updateReview(Long id, Review review);
    void deleteReview(Long id);
}
