package com.example.receipt_processor.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Item {

    private String shortDescription;
    private String price;
}
