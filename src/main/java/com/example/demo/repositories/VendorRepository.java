package com.example.demo.repositories;

import com.example.demo.models.Vendor;
import org.springframework.data.repository.CrudRepository;

public interface VendorRepository extends CrudRepository<Vendor, Integer> {
}

