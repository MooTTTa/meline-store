package com.meline.store.dto;

import com.meline.store.enums.Status;
import com.meline.store.model.Clothes;
import lombok.AllArgsConstructor;


public record ClothesResponseDTO(
        Long id,
        String name,
        String description,
        String image,
        Double price,
        String size,
        Integer amount,
        Status status
) {
    public ClothesResponseDTO(Clothes clothes) {
        this(
                clothes.getId(),
                clothes.getName(),
                clothes.getDescription(),
                clothes.getImage(),
                clothes.getPrice(),
                clothes.getSize(),
                clothes.getAmount(),
                clothes.getStatus());
    }
}
