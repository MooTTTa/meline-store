package com.meline.store.dto;

import com.meline.store.model.Clothes;

public record ClothesRequestDTO(
        String name,
        String description,
        String image,
        Double price,
        String size,
        Integer amount
) {
}
