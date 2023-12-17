package Main.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import Main.Model.Insurance;

@EnableMongoRepositories
public interface InsuranceRepo extends MongoRepository<Insurance,String> {
   
}