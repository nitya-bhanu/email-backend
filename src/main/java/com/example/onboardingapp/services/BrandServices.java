package com.example.onboardingapp.services;

import com.example.onboardingapp.domain.Brand;
import com.example.onboardingapp.repositories.BrandRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServices {

    private final BrandRepositories brandRepositories;

    public String saveBrandRequests(Brand brand){
        brandRepositories.save(brand);
        return "Brand Request Saved successfully";
    }

    public List<Brand> getBrandRequests(){
        return brandRepositories.findAll();
    }

    public String deleteBrandById(String brandId){
        brandRepositories.deleteById(brandId);
        return "Brand Request Deleted Successfully";
    }


}
