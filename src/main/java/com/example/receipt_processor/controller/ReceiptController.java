package com.example.receipt_processor.controller;

import com.example.receipt_processor.model.Receipt;
import com.example.receipt_processor.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {
    @Autowired
    public ReceiptService receiptService;
    @GetMapping("/{id}/points")
    public Map<String,String> getPointsByReward(@PathVariable String id){
    return Collections.singletonMap("points",receiptService.getPoints(id));
}
    @PostMapping("/process")
    public Map<String,String> submitReceipt(@RequestBody Receipt receipt){
    return Collections.singletonMap("receipt",receiptService.submitReceipt(receipt));
}
}
