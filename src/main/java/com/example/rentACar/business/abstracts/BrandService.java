package com.example.rentACar.business.abstracts;

import com.example.rentACar.business.requests.CreateBrandRequest;
import com.example.rentACar.business.requests.UpdateBrandRequest;
import com.example.rentACar.business.responses.GetAllBrandsResponses;
import com.example.rentACar.business.responses.GetByIdBrandResponse;

import java.util.List;

public interface BrandService {

    List<GetAllBrandsResponses> getALl();
    GetByIdBrandResponse getById(int id);
    void add (CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
}
