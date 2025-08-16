package com.platoons.e_commerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "extra_info")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExtraInfo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID extraInfoId;

    @OneToOne(mappedBy = "extraInfo")
    private Product product;

    private String packaging;

    private String weight;

    private String height;

    private String width;

    @NotBlank(message = "Information cannot be empty")
    @Column(columnDefinition = "TEXT")
    private String information;
}
