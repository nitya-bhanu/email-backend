package com.example.onboardingapp.repositories;

import com.example.onboardingapp.domain.Brand;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BrandRepositories extends MongoRepository<Brand,String> {
}
