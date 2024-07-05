package com.example.rentACar.webApi.controllers;

import com.example.rentACar.business.abstracts.CarService;
import com.example.rentACar.business.requests.CreateCarRequest;
import com.example.rentACar.business.requests.UpdateCarRequest;
import com.example.rentACar.business.requests.UpdateModelRequest;
import com.example.rentACar.business.responses.GetAllCarsResponse;
import com.example.rentACar.business.responses.GetByIdBrandResponse;
import com.example.rentACar.business.responses.GetByIdCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
@AllArgsConstructor
public class CarsController {
    private CarService carService;

    @GetMapping
    public List<GetAllCarsResponse> getAllCars() {
        return carService.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdCarResponse getById(@PathVariable int id){
        return  carService.getById(id);
    }
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() CreateCarRequest createCarRequest ) {
        this.carService.add(createCarRequest);
    }
    @PutMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@RequestBody UpdateCarRequest updateCarRequest) {
        this.carService.update(updateCarRequest);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable int id ) {
        this.carService.delete(id);
    }
}
