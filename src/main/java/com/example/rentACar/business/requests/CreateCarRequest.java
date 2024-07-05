package com.example.rentACar.business.requests;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
    private String plate;
    private double dailyPrice;
    private int modelYear;
    private int state;
    @NotNull
    @NotBlank
    private int modelId;
}
