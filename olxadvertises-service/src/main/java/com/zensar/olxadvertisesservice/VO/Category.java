package com.zensar.olxadvertisesservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private int id;
    private String category;
    private String description;

}
