package app.account;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountMongoRepository extends MongoRepository<AccountMongo, String> {
}
