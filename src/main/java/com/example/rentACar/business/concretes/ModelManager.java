package com.example.rentACar.business.concretes;

import com.example.rentACar.business.abstracts.ModelService;
import com.example.rentACar.business.requests.CreateModelRequest;
import com.example.rentACar.business.requests.UpdateBrandRequest;
import com.example.rentACar.business.requests.UpdateModelRequest;
import com.example.rentACar.business.responses.GetAllModelsResponse;
import com.example.rentACar.business.responses.GetByIdBrandResponse;
import com.example.rentACar.business.responses.GetByIdModelResponse;
import com.example.rentACar.core.utilities.mapper.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.ModelRepository;
import com.example.rentACar.entities.concretes.Brand;
import com.example.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager  implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();

        List<GetAllModelsResponse> responses = models.stream()
                .map(model -> this.modelMapperService.forResponse()
                .map(model, GetAllModelsResponse.class)).collect(Collectors.toList());

        return responses;
    }

    @Override
    public GetByIdModelResponse getById(int id) {
        Model model  = this.modelRepository.findById(id).orElseThrow();

        GetByIdModelResponse response = this.modelMapperService.forResponse()
                .map(model, GetByIdModelResponse.class);

        return response;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Brand brand = new Brand();
        brand.setId(createModelRequest.getBrandId());

        Model model = new Model();
        model.setName(createModelRequest.getName());
        model.setBrand(brand);

        this.modelRepository.save(model);
    }

    @Override
    public void update(UpdateModelRequest updateModelRequest) {
        Model model = this.modelMapperService.forRequest().map(updateModelRequest, Model.class);
        this.modelRepository.save(model);
    }

    @Override
    public void delete(int id) {
        this.modelRepository.deleteById(id);
    }
}
