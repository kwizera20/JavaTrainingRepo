package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/nawabClubSearch")
@ComponentScan(basePackages = {
        "com.example.demo"
})
public class SearchController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SearchController.class);


    @GetMapping(path="/getAllData",produces = "application/json")
    public ResponseEntity<Object> getAllClubs(HttpServletRequest request) throws Exception {
        LOGGER.info("came to getAllData");
        List<String> clubs = new ArrayList<String>();
        return ResponseEntity.ok().body(clubs);
    }
}
