package com.events.events.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorCompletionService;

@Repository
public class pageListingRepository {
    @Autowired
    JdbcTemplate JdbcTemplate;

    public List<Map<String,Object>> getpageListing(){
        return JdbcTemplate.queryForList("EXEC shows.spfetchEvents");
    }
}
