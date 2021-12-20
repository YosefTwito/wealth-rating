package com.example.wealthrating.rich;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "central-bank")
public class central_bank_controller {

    @GetMapping("/wealth-threshold")
    public Long getThreshold(){
        return 9000000L;
    }

    @GetMapping("/regional-info/evaluate")
    public int evaluate(@RequestParam("city") String city){

        switch (city){

            case "Washington":
                return 500000;

            case "New York":
                return 900000;

            case "Amsterdam":
                return 1000000;

            case "Bikini Bottom":
                return 800000;

            default:
                return 450000;

        }

    }


}