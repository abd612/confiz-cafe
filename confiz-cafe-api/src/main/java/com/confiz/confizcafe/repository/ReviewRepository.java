package com.confiz.confizcafe.repository;

//import com.confiz.confizcafe.model.Review;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class ReviewRepository {
//
//    private static final String COLLECTION = "review";
//
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    public List<Review> getAllReviews() {
//        return mongoTemplate.findAll(Review.class, COLLECTION);
//    }
//
//    public Review getReviewById(String id) {
//        return mongoTemplate.findById(id, Review.class, COLLECTION);
//    }
//
//    public List<Review> getReviewsByLunchId(String lunchId) {
//        Query query = new Query(Criteria.where("lunchId").is(lunchId));
//        return mongoTemplate.find(query, Review.class, COLLECTION);
//    }
//
//    public List<Review> getReviewsByEmployeeId(Integer employeeId) {
//        Query query = new Query(Criteria.where("employeeId").is(employeeId));
//        return mongoTemplate.find(query, Review.class, COLLECTION);
//    }
//
//    public Review createReview(Review review) {
//        return mongoTemplate.save(review, COLLECTION);
//    }
//
//    public Review updateReview(Review review) {
//        return mongoTemplate.save(review, COLLECTION);
//    }
//
//    public void deleteReview(Review review) {
//        mongoTemplate.remove(review, COLLECTION);
//    }
//}
