package com.platoons.e_commerce.repository;

import com.platoons.e_commerce.entity.ExtraInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtraInfoRepository extends CrudRepository<ExtraInfo, Long> {
}
