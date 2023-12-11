package com.example.onboardingapp.controller;


import com.example.onboardingapp.domain.Brand;
import com.example.onboardingapp.services.BrandServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/brand")
public class BrandController {

    private final BrandServices brandServices;

    @PostMapping("")
    public String saveBrandRequests(@RequestBody Brand brand){
       return brandServices.saveBrandRequests(brand);
    }

    @GetMapping("")
    public List<Brand> getBrandRequests(){
        return brandServices.getBrandRequests();
    }

    @DeleteMapping("/{brandId}")
    public String deleteBrandById(@PathVariable String brandId){
        brandServices.deleteBrandById(brandId);
        return "Brand Request Deleted Successfully";
    }
}
