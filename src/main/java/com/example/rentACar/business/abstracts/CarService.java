package com.example.rentACar.business.abstracts;

import com.example.rentACar.business.requests.CreateCarRequest;
import com.example.rentACar.business.requests.CreateModelRequest;
import com.example.rentACar.business.requests.UpdateCarRequest;
import com.example.rentACar.business.requests.UpdateModelRequest;
import com.example.rentACar.business.responses.GetAllCarsResponse;
import com.example.rentACar.business.responses.GetAllModelsResponse;
import com.example.rentACar.business.responses.GetByIdCarResponse;
import com.example.rentACar.business.responses.GetByIdModelResponse;

import java.util.List;

public interface CarService {
    List<GetAllCarsResponse> getAll();
    GetByIdCarResponse getById(int id);
    void add(CreateCarRequest createCarRequest);
    void update(UpdateCarRequest updateCarRequest);
    void delete(int id);
}
