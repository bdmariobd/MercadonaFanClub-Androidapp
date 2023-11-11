package com.bdmariobd.mercadonafc.activities.product_detail;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;
import java.util.Objects;

public class Review {
    private String review;
    private Float rating;
    private Date date;
    private String author;

    private String userId;

    private String id;

    private String productName;

    private Boolean isVerified = false;

    private String productId;

    public Review() {
        // Needed for Firebase
    }

    public Review(@Nullable String review, @NonNull Float rating, @NonNull String author, @NonNull String id, @NonNull String userId, @NonNull String productName, @NonNull String productId) {
        this.review = review;
        this.rating = rating;
        this.author = author;
        this.userId = userId;
        this.id = id;
        this.productName = productName;
        this.productId = productId;
    }

    public Review(@Nullable String review, @NonNull Float rating, @NonNull String author, @NonNull String id, @NonNull String userId, @NonNull String productName, @NonNull Boolean isVerified , @NonNull String productId) {
        this.review = review;
        this.rating = rating;
        this.author = author;
        this.userId = userId;
        this.id = id;
        this.productName = productName;
        this.isVerified = isVerified;
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Boolean getVerified() {
        return isVerified;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Nullable
    public String getReview() {
        return review;
    }

    public void setReview(@Nullable String review) {
        this.review = review;
    }

    @NonNull
    public Float getRating() {
        return rating;
    }

    public void setRating(@NonNull Float rating) {
        this.rating = rating;
    }

    @ServerTimestamp
    @NonNull
    public Date getDate() {
        return date;
    }

    public void setDate(@NonNull Date date) {
        this.date = date;
    }

    @NonNull
    public String getAuthor() {
        return author;
    }

    public void setAuthor(@NonNull String author) {
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NonNull
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review1 = (Review) o;
        return Float.compare(review1.rating, rating) == 0 && Objects.equals(review, review1.review) && date.equals(review1.date) && author.equals(review1.author) && id.equals(review1.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(review, rating, date, author, id);
    }

    @androidx.annotation.NonNull
    @Override
    public String toString() {
        return "Review{" +
                "review='" + review + '\'' +
                ", rating=" + rating +
                ", date=" + date +
                ", author='" + author + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
