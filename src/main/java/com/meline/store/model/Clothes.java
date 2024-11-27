package com.meline.store.model;


import com.meline.store.enums.Status;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "clothes")
@Entity(name = "clothes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Clothes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String image;
    private Double price;
    private String size;
    private Integer amount;

    @Enumerated(EnumType.STRING)
    private Status status;
}
