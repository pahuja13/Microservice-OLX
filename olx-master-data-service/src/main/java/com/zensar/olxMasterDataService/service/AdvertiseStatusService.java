package com.zensar.olxMasterDataService.service;

import com.zensar.olxMasterDataService.entity.AdvertiseStatus;
import com.zensar.olxMasterDataService.entity.StatusList;
import com.zensar.olxMasterDataService.repository.AdvertiseStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertiseStatusService {

    @Autowired
    private AdvertiseStatusRepository advertiseStatusRepository;

    public AdvertiseStatus saveAdvertiseStatus(AdvertiseStatus advertiseStatus) {
        return advertiseStatusRepository.save(advertiseStatus);
    }

    public StatusList getAllAdvertiseStatus() {
        StatusList statusList = new StatusList();
        statusList.setStatusList(advertiseStatusRepository.findAll());
        return statusList;
    }
}

