package Main.Model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("Users")
public class User {
    @Id
    private String id;
    
    public boolean logged_in;
    public String Name;
    public String Password;
    public  ArrayList<String> Insurance_Portfoy;
    
    
    public User(String Name,String Password){
        this.Insurance_Portfoy=new ArrayList<>();
        this.Name=Name;
        this.Password=Password;
    }
    
  
    public String getName (){
       
        return Name;
    }

    public void AddInsuranceToPortfoy(String InsuranceID){
        this.Insurance_Portfoy.add(InsuranceID);
    }

    public void DeleteInsuranceFromPortfoy(String InsuranceID){
        this.Insurance_Portfoy.remove(InsuranceID);
    }

    public void setName (String Name){
        this.Name = Name;
    }

    public String getPassword(){  
        return this.Password;
    }

    public void setPassword(String Password){
        this.Password = Password;
    }
    
    public boolean setLoggedIn(){
        return this.logged_in;    
    }


    public void setLogged(Boolean logged_in){
        this.logged_in = logged_in;
        
    }
 
    public String getID (){
        return this.id;
    }

    
     

}
