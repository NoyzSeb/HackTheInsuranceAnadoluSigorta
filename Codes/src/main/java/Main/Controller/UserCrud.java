package Main.Controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import Main.Model.User;
import Main.Repositories.UserRepo;


@Service
public class UserCrud {
    
    @Autowired
    UserRepo userRepo;

    public User searchedUser;
    public boolean userExist;
    

    public User createUser(User user){
        return userRepo.save(user);
    }

    public User getUserByID(String id){
        return userRepo.findById(id).orElseThrow(()-> new RuntimeException("Couldnt find the user with"+id));
    }

   
    public User getUserByName(String name) throws Exception{
        for(int i=0; i<getAllUsers().size();i++){
            if(getAllUsers().get(i).getName().equals(name)){
               System.out.println("Input " + name + " Data "+ getAllUsers().get(i) );
               searchedUser = getAllUsers().get(i);
            }
        }

        if(searchedUser !=null){
            return searchedUser;
        }else{
            throw new Exception("There is no User with this name. "+name);
        }
      
    }

    public User updateUser(String id,User user){
        User oldUser= getUserByID(id);
        if(user.getName()!=null)oldUser.setName(user.getName());
        if(user.getPassword()!=null)oldUser.setPassword(user.getPassword());
        if(user.setLoggedIn()!=true)oldUser.setLogged(user.setLoggedIn());
        
        return userRepo.save(oldUser);
    }

    public User addInsurance(String InsuranceID,String id){
        User oldUser = getUserByID(id);
        
        oldUser.AddInsuranceToPortfoy(InsuranceID);
        
        return userRepo.save(oldUser);
    }

    public User deleteInsurance(String id,String InsuranceID){
        User oldUser = getUserByID(id);
        
        oldUser.DeleteInsuranceFromPortfoy(InsuranceID);
        
        return userRepo.save(oldUser);
    }

    public User logIn(String Name, String Password) throws Exception{
            User logging_user=getUserByName(Name);
        try {     
                    
            if(logging_user.getPassword().equals(Password)&&logging_user.getName().equals(Name)){
                 logging_user.setLogged(true);
                 userRepo.save(logging_user);
                 return logging_user;
             }else{
                 throw new Exception("Invalid Login or already Logged In");
             }
        } catch (Exception e) {
          System.out.println(e.getClass() + " " + e.getCause());
           System.out.println(logging_user);
           return logging_user;

          
        } 
    }

    public void deletUserByID(String id){
        userRepo.deleteById(id);
        
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }
}
