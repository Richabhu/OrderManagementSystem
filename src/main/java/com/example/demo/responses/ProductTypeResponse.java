package com.example.demo.responses;

import com.example.demo.models.ProductType;
import com.example.demo.utiles.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductTypeResponse extends BaseResponse {

    private List<ProductType> productTypeList;
}
