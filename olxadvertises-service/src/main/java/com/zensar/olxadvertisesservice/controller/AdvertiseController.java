package com.zensar.olxadvertisesservice.controller;

import com.zensar.olxadvertisesservice.VO.Categories;
import com.zensar.olxadvertisesservice.VO.ResponseTemplateVO;
import com.zensar.olxadvertisesservice.VO.StatusList;
import com.zensar.olxadvertisesservice.entity.Advertise;
import com.zensar.olxadvertisesservice.service.AdvertiseService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping("/advertise")
public class AdvertiseController {

    private static final String ADVERTISE_SERVICE = "advertiseService";
    @Autowired
    private AdvertiseService advertiseService;
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("")
    public ResponseTemplateVO saveAdvertise(@RequestBody Advertise advertise){
        return advertiseService.saveAdvertise(advertise);
    }

    @PutMapping("/{id}")
    public ResponseTemplateVO updateAdvertise(@RequestBody Advertise advertise, @PathVariable("id")int id){
        return advertiseService.updateAdvertise(advertise,id);
    }

    @GetMapping("/{postId}")
    @CircuitBreaker(name = ADVERTISE_SERVICE, fallbackMethod = "advertiseFallback")
    public ResponseTemplateVO getAdvertise(@PathVariable("postId") int postId){
        Categories categories = restTemplate.getForObject( "http://OLX-MASTER-DATE-SERVICE/master/category" , Categories.class);
        StatusList statusList = restTemplate.getForObject( "http://OLX-MASTER-DATE-SERVICE/master/status" , StatusList.class);
        return advertiseService.getAdvertise(postId,categories,statusList);
    }

    @DeleteMapping("/{postId}")
    public boolean deleteAdvertise(@PathVariable("postId") int postId){
        return advertiseService.deleteAdvertise(postId);
    }

    public ResponseTemplateVO advertiseFallback(Exception e){
        ResponseTemplateVO vo = new ResponseTemplateVO();
        vo.setId(0);
        vo.setCategory("Service Failure");
        return vo;
    }


}
