package edu.icet.crm.Service.impl;

import edu.icet.crm.Service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.Map;

//@Component ----> childs->@Service, @Repository
//@Service ---> new ProductServiceImpl() ---> IOC Container
@Service
@Slf4j
//@Lazy
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // Avoid default sigleton and create seperate objects
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) //To Re-enable singleton
public class ProductServiceImpl implements ProductService {

    public ProductServiceImpl(){
        log.info("ProductServiceImpl Object Loaded");
    }

    public Map<String,String> getStudent(){
        return Collections.singletonMap("name","Ravindu");
    }
}
