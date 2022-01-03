package com.zensar.olxMasterDataService.service;


import com.zensar.olxMasterDataService.entity.AdvertiseStatus;
import com.zensar.olxMasterDataService.entity.Categories;
import com.zensar.olxMasterDataService.entity.Category;
import com.zensar.olxMasterDataService.entity.StatusList;
import com.zensar.olxMasterDataService.repository.AdvertiseStatusRepository;
import com.zensar.olxMasterDataService.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public Category saveCategories(Category category) {
        return categoryRepository.save(category);
    }




    public Categories getAllCategories() {
        Categories categories = new Categories();
        categories.setCategories(categoryRepository.findAll());
        return categories;
    }


}
