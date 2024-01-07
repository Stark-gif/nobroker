package com.nobroker.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class OwnerPlanDto {

    private long planId;

    private String planName;

    private double price;

    private int planeValidity;

    private boolean relationshipManager;

    private boolean rentalAgreement;

    private boolean propertyPromotion;

    private boolean guaranteedTenants;

    private boolean showingProperty;

    private boolean facebookMarketingOfProperty;


}