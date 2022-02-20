package com.example.demo.controllers;


import com.example.demo.models.ProductType;
import com.example.demo.models.Vendor;
import com.example.demo.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    @Autowired
    public VendorService vendorService;


    @GetMapping("")
    private List<Vendor> getAllVendors()
    {
        return vendorService.getAllVendors();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Vendor> getVendor(@PathVariable("id") int id)
    {
        Vendor vendor =vendorService.getVendorById(id);
        if(vendor != null)
            return ResponseEntity.ok(vendor);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Vendor> deleteVendor(@PathVariable("id") int id)
    {

        Vendor vendor = vendorService.delete(id);
        if(vendor != null)
            return ResponseEntity.ok(vendor);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @PostMapping("")
    private Vendor saveVendor(@Validated @RequestBody Vendor vendor)
    {
        vendorService.saveOrUpdate(vendor);
        return vendor;
    }

    @PutMapping("")
    private Vendor update(@Validated @RequestBody Vendor vendor)
    {
        vendorService.saveOrUpdate(vendor);
        return vendor;
    }

}
