package com.zensar.olxadvertisesservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private int id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String username;
    private Date createdDate;
    private Date modifiedDate;
    private String status;
}

