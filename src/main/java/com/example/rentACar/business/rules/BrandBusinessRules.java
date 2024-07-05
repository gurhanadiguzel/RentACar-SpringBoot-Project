package com.example.rentACar.business.rules;

import com.example.rentACar.core.utilities.exceptions.BusinessException;
import com.example.rentACar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class BrandBusinessRules {
    private BrandRepository brandRepository;

    public void checkIfBrandNameExists(String brandName) {
        if(brandRepository.existsByName(brandName)){
            throw new BusinessException("Brand name already exists");
        }
    }
}
