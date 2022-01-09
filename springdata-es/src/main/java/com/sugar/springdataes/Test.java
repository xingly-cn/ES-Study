package com.sugar.springdataes;



import com.sugar.springdataes.entity.Product;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    private ElasticsearchRestTemplate template;

    @org.junit.Test
    public void createIndex(){

    }

    @org.junit.Test
    public void deleteIndex(){
        String delete = template.delete(Product.class);
        System.out.println(delete);
    }

}
