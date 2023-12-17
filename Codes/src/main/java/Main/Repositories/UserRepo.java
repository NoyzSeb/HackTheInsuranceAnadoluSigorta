package Main.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


import Main.Model.User;

@EnableMongoRepositories
public interface UserRepo extends MongoRepository<User,String> {
   
}
