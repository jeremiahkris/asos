package com.example.asosdata;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Controller {

    private String filename;

    @RequestMapping("/product")
    public String product(@RequestParam(name="productId") String productId){
        filename =  productId + "-2022-12-13.json";

        String Data = GetBlob.getData(filename);
        return Data;
    }


    }

