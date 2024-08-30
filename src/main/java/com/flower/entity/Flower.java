package com.flower.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Flower {

    private Long id;
    private final Long id_profile;
    private final String description;
    private final String name;

}