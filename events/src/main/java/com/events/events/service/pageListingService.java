package com.events.events.service;

import com.events.events.repository.pageListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class pageListingService {
    @Autowired
    private pageListingRepository pagelistingrepository;

    public List<Map<String,Object>> getpageListing(){
        return pagelistingrepository.getpageListing();
    }
}
