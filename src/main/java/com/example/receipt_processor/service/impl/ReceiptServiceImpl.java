package com.example.receipt_processor.service.impl;

import com.example.receipt_processor.model.Item;
import com.example.receipt_processor.model.Receipt;
import com.example.receipt_processor.service.ReceiptService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    private final Map<String, Integer> receiptPoints = new HashMap<>();
    @Override
    public String submitReceipt(Receipt receipt) {
        String id = UUID.randomUUID().toString();
        int points = calculatePoints(receipt);
        receiptPoints.put(id, points);
        return id;
    }
    @Override
    public String getPoints(String id) {

        return receiptPoints.getOrDefault(id, 0).toString();
    }

    private int calculatePoints(Receipt receipt) {
        int points = 0;
        points += receipt.getRetailer().replaceAll("[^a-zA-Z0-9]", "").length();
        if (receipt.getTotal().matches("\\d+\\.00")) points += 50;
        if (new BigDecimal(receipt.getTotal()).remainder(new BigDecimal("0.25")).compareTo(BigDecimal.ZERO) == 0)
            points += 25;
        points += (receipt.getItems().size() / 2) * 5;
        for (Item item : receipt.getItems()) {
            int len = item.getShortDescription().trim().length();
            if (len % 3 == 0) {
                BigDecimal price = new BigDecimal(item.getPrice());
                points += new BigDecimal(String.valueOf(price.multiply(new BigDecimal("0.2")).setScale(0, RoundingMode.UP))).intValue();
            }
        }
        if (Integer.parseInt(receipt.getPurchaseDate().split("-")[2]) % 2 != 0) points += 6;
        LocalTime time = LocalTime.parse(receipt.getPurchaseTime());
        if (!time.isBefore(LocalTime.of(14, 0)) && time.isBefore(LocalTime.of(16, 0))) points += 10;

        return points;
    }
}
