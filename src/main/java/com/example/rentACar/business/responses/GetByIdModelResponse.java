package com.example.rentACar.business.responses;

import com.example.rentACar.entities.concretes.Brand;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdModelResponse {
    private int id;
    private String name;
    private String brandName;
}
