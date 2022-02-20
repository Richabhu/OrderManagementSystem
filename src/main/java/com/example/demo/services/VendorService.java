package com.example.demo.services;

import com.example.demo.models.ProductType;
import com.example.demo.models.Vendor;
import com.example.demo.repositories.ProductTypeRepository;
import com.example.demo.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VendorService {

    @Autowired
    VendorRepository vendorRepository;

    public List<Vendor> getAllVendors()
    {
        List<Vendor> vendors = new ArrayList<Vendor>();
        vendorRepository.findAll().forEach(vendor -> vendors.add(vendor));
        return vendors;
    }

    public Vendor getVendorById(int id)
    {
        Optional<Vendor> vendor= vendorRepository.findById(id);
        if(vendor.isPresent())
            return vendor.get();
        return null;
    }

    public void saveOrUpdate(Vendor vendor)
    {
        vendorRepository.save(vendor);
    }

    public Vendor delete(int id)
    {
        Optional<Vendor> vendor= vendorRepository.findById(id);
        if(vendor.isPresent()){
            vendorRepository.deleteById(id);
            return vendor.get();
        }
        return null;

    }

    //updating a record
    public void update(Vendor vendor, int id)
    {
        vendorRepository.save(vendor);
    }
}
