package com.zensar.olxMasterDataService.controller;
import com.zensar.olxMasterDataService.entity.AdvertiseStatus;
import com.zensar.olxMasterDataService.entity.Categories;
import com.zensar.olxMasterDataService.entity.Category;
import com.zensar.olxMasterDataService.entity.StatusList;
import com.zensar.olxMasterDataService.service.AdvertiseStatusService;
import com.zensar.olxMasterDataService.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
//@RequestMapping("/advertise")
@RequestMapping("/master")
public class CategoriesController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AdvertiseStatusService advertiseStatusService;


    @PostMapping("/")
    public Category saveCategories(@RequestBody Category category){
        return categoryService.saveCategories(category);
    }

    @GetMapping("/category")
    public Categories getAllCategories(){
        return categoryService.getAllCategories();
    }


    @GetMapping("/status")
    public StatusList getAdvertiseStatus(){
        return advertiseStatusService.getAllAdvertiseStatus();
    }


    @PostMapping("/saveadvertisestatus")
    public AdvertiseStatus saveAdvertiseStatus(@RequestBody AdvertiseStatus advertiseStatus){
        return advertiseStatusService.saveAdvertiseStatus(advertiseStatus);
    }

}
