package com.zensar.olxMasterDataService.repository;

import com.zensar.olxMasterDataService.entity.AdvertiseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertiseStatusRepository extends JpaRepository<AdvertiseStatus,Integer> {
}
