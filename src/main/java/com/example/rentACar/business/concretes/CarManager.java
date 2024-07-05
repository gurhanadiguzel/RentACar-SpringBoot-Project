package com.example.rentACar.business.concretes;

import com.example.rentACar.business.abstracts.CarService;
import com.example.rentACar.business.requests.CreateCarRequest;
import com.example.rentACar.business.requests.UpdateCarRequest;
import com.example.rentACar.business.responses.GetAllCarsResponse;
import com.example.rentACar.business.responses.GetByIdCarResponse;
import com.example.rentACar.business.responses.GetByIdModelResponse;
import com.example.rentACar.core.utilities.mapper.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.CarRepository;
import com.example.rentACar.entities.concretes.Car;
import com.example.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private CarRepository carRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllCarsResponse> getAll() {
        List<Car> cars = carRepository.findAll();

        List<GetAllCarsResponse> responses = cars.stream()
                .map(car -> this.modelMapperService.forResponse()
                        .map(car, GetAllCarsResponse.class))
                .collect(Collectors.toList());

        return responses;
    }

    @Override
    public GetByIdCarResponse getById(int id) {
        Car car  = this.carRepository.findById(id).orElseThrow();
        GetByIdCarResponse response = this.modelMapperService.forResponse()
                .map(car, GetByIdCarResponse.class);

        return response;
    }

    @Override
    public void add(CreateCarRequest createCarRequest) {
        Model model = new Model();
        model.setId(createCarRequest.getModelId());

        Car car = new Car();
        car.setDailyPrice(createCarRequest.getDailyPrice());
        car.setState(createCarRequest.getState());
        car.setPlate(createCarRequest.getPlate());
        car.setModelYear(createCarRequest.getModelYear());
        car.setModel(model);

//        Car car = this.modelMapperService.forRequest().map(updateCarRequest, Car.class);
        this.carRepository.save(car);
    }

    @Override
    public void update(UpdateCarRequest updateCarRequest) {
        Car car = this.modelMapperService.forRequest().map(updateCarRequest, Car.class);
        this.carRepository.save(car);
    }

    @Override
    public void delete(int id) {
        this.carRepository.deleteById(id);
    }
}
