package com.example.receipt_processor.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Receipt {
    private String retailer;
    private String purchaseDate;
    private String purchaseTime;
    private ArrayList<Item> items;
    private String total;
}
