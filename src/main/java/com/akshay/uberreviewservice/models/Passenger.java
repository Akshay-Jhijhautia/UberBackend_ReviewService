package com.akshay.uberreviewservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Passenger extends BaseModel {

    private String name;

    @Column(nullable = false, unique = true)
    private String panDetails;

    // 1:N relationship, passenger has many bookings
    @OneToMany(mappedBy = "passenger")
    private List<Booking> bookings = new ArrayList<>();

}
