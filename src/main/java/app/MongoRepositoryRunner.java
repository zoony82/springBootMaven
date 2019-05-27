package app;

import app.account.AccountMongo;
import app.account.AccountMongoRepository;
import app.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class MongoRepositoryRunner implements ApplicationRunner {

    @Autowired
    AccountMongoRepository accountMongoRepository;

    @Override
    public void run(ApplicationArguments args){
        AccountMongo accountMongo = new AccountMongo();
        accountMongo.setEmail("abc2@gmail.com");
        accountMongo.setUsername("jjh2");
        accountMongoRepository.insert(accountMongo);

        System.out.println("mongo repo test complete");

    }



}
