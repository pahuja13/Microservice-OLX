package com.zensar.olxadvertisesservice.service;

import com.zensar.olxadvertisesservice.VO.*;
import com.zensar.olxadvertisesservice.entity.Advertise;
import com.zensar.olxadvertisesservice.repository.AdvertiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class AdvertiseService {

    @Autowired
    private AdvertiseRepository advertiseRepository;



    public ResponseTemplateVO saveAdvertise(Advertise advertise) {
        Advertise ad = advertiseRepository.save(advertise);
        ResponseTemplateVO vo = new ResponseTemplateVO();
        if(ad.getStatus()==0){
            vo.setStatus("OPEN");
        }
        if(ad.getUsername()==null){
            vo.setUsername("TEST");
        }
        if(ad.getCategoryId()==1){
            vo.setCategory("ABC");
        }else if(ad.getCategoryId()==2){
            vo.setCategory("XYZ");
        }
        vo.setPrice(ad.getPrice());
        vo.setDescription(ad.getDescription());
        vo.setTitle(ad.getTitle());
        vo.setId(ad.getId());
        vo.setCreatedDate(ad.getCreated_date());
        vo.setModifiedDate(ad.getModified_date());
        return vo;
    }



    public ResponseTemplateVO updateAdvertise(Advertise advertise,int id) {
        int categoryId = id;
        Optional<Advertise> updated_ad = Optional.of(new Advertise());
        if(advertiseRepository.existsById(categoryId)) {
            updated_ad = advertiseRepository.findById(categoryId);
            updated_ad.get().setTitle(advertise.getTitle());
            updated_ad.get().setCategoryId(advertise.getCategoryId());
            updated_ad.get().setStatus(advertise.getStatus());
            updated_ad.get().setPrice(advertise.getPrice());
            updated_ad.get().setDescription(advertise.getDescription());
            advertiseRepository.save(updated_ad.get());
        }
        ResponseTemplateVO vo = new ResponseTemplateVO();
        if(updated_ad.get().getStatus()==0){
            vo.setStatus("OPEN");
        }else if(updated_ad.get().getStatus()==1){
            vo.setStatus("CLOSE");
        }
        if(updated_ad.get().getUsername()!=null){
            vo.setUsername("TEST");
        }
        if(updated_ad.get().getCategoryId()==1){
            vo.setCategory("ABC");
        }else if(updated_ad.get().getCategoryId()==2){
            vo.setCategory("XYZ");
        }
        vo.setPrice(updated_ad.get().getPrice());
        vo.setDescription(updated_ad.get().getDescription());
        vo.setTitle(updated_ad.get().getTitle());
        vo.setId(updated_ad.get().getId());
        vo.setCreatedDate(updated_ad.get().getCreated_date());
        vo.setModifiedDate(updated_ad.get().getModified_date());
        return vo;
    }

    public ResponseTemplateVO getAdvertise(int postId,Categories categories, StatusList statusList) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Optional<Advertise> ad = Optional.of(new Advertise());
        ad = advertiseRepository.findById(postId);
//      Categories categories = restTemplate.getForObject( "http://OLX-MASTER-DATE-SERVICE/master/category" , Categories.class);
//      StatusList statusList = restTemplate.getForObject( "http://OLX-MASTER-DATE-SERVICE/master/status" , StatusList.class);


        for (AdvertiseStatus status: statusList.getStatusList()) {
            if(ad.get().getCategoryId()==status.getId()){
                vo.setStatus(status.getStatus());
            }
        }
        for(Category category: categories.getCategories()){
            if(ad.get().getCategoryId()==category.getId()){
                vo.setCategory(category.getCategory());
            }
        }
        vo.setPrice(ad.get().getPrice());
        vo.setDescription(ad.get().getDescription());
        vo.setTitle(ad.get().getTitle());
        vo.setId(ad.get().getId());
        vo.setCreatedDate(ad.get().getCreated_date());
        vo.setModifiedDate(ad.get().getModified_date());
        return vo;
    }

    public boolean deleteAdvertise(int postId) {
         if(advertiseRepository.existsById(postId)){
             advertiseRepository.deleteById(postId);
             return true;
         }else{
             return false;
         }

    }
}
