package com.akshay.uberreviewservice.services;

import com.akshay.uberreviewservice.models.Booking;
import com.akshay.uberreviewservice.models.Review;
import com.akshay.uberreviewservice.repositories.BookingRepository;
import com.akshay.uberreviewservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService implements CommandLineRunner {
    private ReviewRepository reviewRepository;
    private BookingRepository bookingRepository;

    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("*************");

        Review review =  Review
                .builder()
                .content("Nice Ride")
                .rating(4.5).build();

        Booking booking = Booking
                 .builder()
                 .review(review)
                 .endTime(new Date())
                 .build();

        bookingRepository.save(booking); // this code executes sql query and automatically save review because of cascade

        List<Review> reviewList = reviewRepository.findAll();

        for(Review review1: reviewList) {
            System.out.println(review1.getContent());
        }

//        reviewRepository.deleteById(2L);
    }
}
