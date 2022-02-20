package com.example.demo.exception;


import org.springframework.web.client.HttpClientErrorException;

public class ProductTypeNotFound extends Exception {

    public ProductTypeNotFound(){super();}

    public ProductTypeNotFound(String s){super(s);}


    public ProductTypeNotFound(Throwable s){super(s);}

    public ProductTypeNotFound(String str, Throwable throwable){super(str, throwable);}

}

