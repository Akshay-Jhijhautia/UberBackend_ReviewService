package com.akshay.uberreviewservice.services;

import com.akshay.uberreviewservice.models.Review;
import com.akshay.uberreviewservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService implements CommandLineRunner {
    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World");
        Review review =  Review
                          .builder()
                          .content("Amazing Ride")
                          .rating(4.5).build();
        System.out.println(review);
        reviewRepository.save(review);  // this code executes sql query

        List<Review> reviewList = reviewRepository.findAll();

        for(Review review1: reviewList) {
            System.out.println(review1.getContent());
        }

        reviewRepository.deleteById(2L);
    }
}
