package com.example.deliveryapplication.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Delivery {

    private int orderNumber;
    private Address address;
    private String deliveryTimes;
    private String estimateTime;
    private boolean isFinished;
}
