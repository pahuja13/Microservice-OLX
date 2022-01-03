package com.zensar.olxadvertisesservice.repository;

import com.zensar.olxadvertisesservice.entity.Advertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertiseRepository extends JpaRepository<Advertise, Integer> {
}
