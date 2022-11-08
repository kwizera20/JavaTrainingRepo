package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/controllerMapping")
@Component
public class JavaTrainingController {

    @Autowired
    WordMeaningRepository wordMeaningRepository;
    @Autowired
    CarDetailsRepository carDetailsRepository ;

    private static final Logger LOGGER =
            LoggerFactory.getLogger(JavaTrainingController.class);


    @GetMapping(path="/getSomeStrings",produces = "application/json")
    public ResponseEntity<Object> getSomeStrings(HttpServletRequest request){
        LOGGER.info("came to getAllData");
        List<String> randomStrings = returnDummyList();
        return ResponseEntity.ok().body(randomStrings);
    }

    @GetMapping(path="/getSomeStrings2",produces = "application/json")
    public ResponseEntity<Object> getSomeStrings2(HttpServletRequest request){
        LOGGER.info("came to getAllData2");
        List<String> randomStrings = returnDummyList2();
        return ResponseEntity.ok().body(randomStrings);
    }

    @PostMapping(path="/postSomeStrings", produces = "application/json")
    public ResponseEntity<Object> postSomeStrings(@RequestBody String inputString){
        LOGGER.info("came to post data for string" + inputString);
        List<String> randomStrings = returnPostDummyList(inputString);
        return ResponseEntity.ok().body(randomStrings);
    }

    @PostMapping(path="/postObject", produces = "application/json")
    public ResponseEntity<Object> postObject(@RequestBody Object inputString){
        LOGGER.info("came to post data for string" + inputString);
        List<String> randomStrings = returnDummyList2();
        return ResponseEntity.ok().body(randomStrings);
    }

    @PostMapping(path="/postDog", produces = "application/json")
    public ResponseEntity<Object> postObject(@RequestBody Dog dog){
        LOGGER.info("came to post data for string" + dog);
        if(dog.getColor().equals("red")){
            return ResponseEntity.ok().body("hi - " + dog.getName());
        }
        else{
            return ResponseEntity.ok().body("no hi to you, not red dog - " + dog.getName());
        }
    }

    @PostMapping(path="/postWord", produces = "application/json")
    public ResponseEntity<Object> postObject(@RequestBody WordMeaning wordMeaning){
        LOGGER.info("came to post data for string" + wordMeaning);
        WordMeaning wordMeaning1= wordMeaningRepository.save(wordMeaning);
        return ResponseEntity.ok().body("hi - the generated id post saving object is " + wordMeaning.getId());
    }

    @PostMapping(path="/postCarDetails", produces = "application/json")
    public ResponseEntity<Object> postObject(@RequestBody Car car){
        LOGGER.info("came to post data for string" + car);
        Car name = carDetailsRepository.save(car);
        return ResponseEntity.ok().body("hi - the generated id post saving object is " + car.getId());
    }

    private List<String> returnPostDummyList(String inputString) {
        List<String> list = new ArrayList<String>();
        list.add(inputString);
        return list;
    }


    private List<String> returnDummyList(){
        List<String> list = new ArrayList<String>();
        list.add("hi");
        list.add("bye");
        list.add("ready");
        return list;
    }

    private List<String> returnDummyList2(){
        List<String> list = new ArrayList<String>();
        list.add("hi2");
        list.add("bye2");
        list.add("ready2");
        return list;
    }
    //localhost:8080/controllerMapping/method/

}


