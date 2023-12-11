package com.example.onboardingapp.domain;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Brand {
    @Id
    public String brandId;
    public String brandName;
    public String description;
    public String businessEmailId;
    public String onlineWebsiteLink;
    public List<String> productsCategory;
    public boolean approvalStatus;
}