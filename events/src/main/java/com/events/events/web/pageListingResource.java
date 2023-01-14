package com.events.events.web;

import com.events.events.service.pageListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class pageListingResource {

    @Autowired
    private pageListingService pagelistingservice;

    @GetMapping("/pageListing")
    private List<Map<String,Object>> getpageListing(){
        return pagelistingservice.getpageListing();
    }
}
