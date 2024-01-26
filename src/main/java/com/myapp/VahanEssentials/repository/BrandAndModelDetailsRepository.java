package com.myapp.VahanEssentials.repository;
import com.myapp.VahanEssentials.model.BrandAndModelDetails;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BrandAndModelDetailsRepository extends CrudRepository<BrandAndModelDetails,Integer> {

    List<BrandAndModelDetails> findAllByType(String type);

}
