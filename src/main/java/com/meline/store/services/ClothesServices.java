package com.meline.store.services;

import com.meline.store.dto.ClothesRequestDTO;
import com.meline.store.dto.ClothesResponseDTO;
import com.meline.store.dto.EditRequestDTO;
import com.meline.store.enums.Status;
import com.meline.store.model.Clothes;
import com.meline.store.repository.ClothesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClothesServices {

    @Autowired
    private ClothesRepository repository;

    public void registerClothes(ClothesRequestDTO dto){
        Clothes clothes = new Clothes();
        clothes.setName(dto.name());
        clothes.setDescription(dto.description());
        clothes.setPrice(dto.price());
        clothes.setImage(dto.image());
        clothes.setSize(dto.size());
        clothes.setAmount(dto.amount());

        if(dto.amount() > 0){
            clothes.setStatus(Status.DISPONIVEL);
        } else {
            clothes.setStatus(Status.ESGOTADO);
        }

        repository.save(clothes);
    }

    public List<ClothesResponseDTO> getAllClothes(){
        return repository.findAll().stream().map(ClothesResponseDTO::new).toList();
    }

    public Clothes editClothes(EditRequestDTO dto){
      Clothes clothing = repository.findById(dto.id()).orElseThrow();
      clothing.setAmount(dto.amount());
        if(dto.amount() > 0){
            clothing.setStatus(Status.DISPONIVEL);
        } else {
            clothing.setStatus(Status.ESGOTADO);
        }
      return repository.save(clothing);
    }
}
