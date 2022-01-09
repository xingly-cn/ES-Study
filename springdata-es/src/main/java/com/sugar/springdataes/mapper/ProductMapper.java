package com.sugar.springdataes.mapper;

import com.sugar.springdataes.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;

@Service
public interface ProductMapper extends ElasticsearchRepository<Product,Long> {

}
