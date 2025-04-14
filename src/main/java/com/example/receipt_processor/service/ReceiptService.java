package com.example.receipt_processor.service;

import com.example.receipt_processor.model.Receipt;

public interface ReceiptService {
    String getPoints(String id);
    String submitReceipt(Receipt receipt);
}
