package com.example.wealthrating.rich;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/riches")
public class RichController {

    private final RichService richService;

    @Autowired
    public RichController(RichService richService) {
        this.richService = richService;
    }

    @GetMapping("/all")
    public List<Rich> getAll(){
        return richService.getRiches();
    }

    @GetMapping("/getByID")
    public Rich getByID(@RequestParam("Id") Long Id){
        return richService.getRichById(Id);
    }

    @PostMapping("/saveRich")
    public String saveRich(@RequestBody Person p){
        return richService.postRich(p);
    }
}
