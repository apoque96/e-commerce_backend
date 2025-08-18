package com.platoons.e_commerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.platoons.e_commerce.entity.ExtraInfo;

@Repository
public interface ExtraInfoRepository extends CrudRepository<ExtraInfo, String> {
}
