package app;

import app.account.AccountMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class MongoRunner implements ApplicationRunner {


    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void run(ApplicationArguments args){
        AccountMongo accountMongo = new AccountMongo();
        accountMongo.setEmail("abc@gmail.com");
        accountMongo.setUsername("jjh");

        mongoTemplate.insert(accountMongo);
        System.out.println("mongo test complete");

    }



}
