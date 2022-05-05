package com.confiz.confizcafe.service;

//import com.confiz.confizcafe.model.Review;
//import com.confiz.confizcafe.repository.ReviewRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.List;
//
//@Service
//public class ReviewService {
//
//    @Autowired
//    private ReviewRepository reviewRepository;
//
//    public List<Review> getAllReviews() {
//        return reviewRepository.getAllReviews();
//    }
//
//    public Review getReviewById(String id) {
//        return reviewRepository.getReviewById(id);
//    }
//
//    public List<Review> getReviewsByLunchId(String lunchId) {
//        return reviewRepository.getReviewsByLunchId(lunchId);
//    }
//
//    public List<Review> getReviewsByEmployeeId(Integer employeeId) {
//        return reviewRepository.getReviewsByEmployeeId(employeeId);
//    }
//
//    public Review createReview(String lunchId, Integer employeeId, String comment) {
//        Review review = new Review();
//        if (lunchId != null) review.setLunchId(lunchId);
//        if (employeeId != null) review.setEmployeeId(employeeId);
//        if (comment != null) review.setComment(comment);
//        return reviewRepository.createReview(review);
//    }
//
//    public Review updateReview(Date date, String menu, Double price, Boolean isReady, Boolean isFinished) {
//        Review review = getReviewByDate(date);
//        if (date != null) review.setDate(date);
//        if (menu != null) review.setMenu(menu);
//        if (price != null) review.setPrice(price);
//        if (isReady != null) review.setReady(isReady);
//        if (isFinished != null) review.setFinished(isFinished);
//        return reviewRepository.updateReview(review);
//    }
//
//    public void deleteReview(String id) {
//        Review review = getReviewById(id);
//        reviewRepository.deleteReview(review);
//    }
//}
