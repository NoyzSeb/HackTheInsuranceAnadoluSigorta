package Main.Services;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Main.Controller.UserCrud;
import Main.Model.User;




@RestController
@RequestMapping("api")
public class UserServ {
    
	@Autowired
	private UserCrud userCrud;

    @GetMapping("home")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello %s!", "Berk");
    }

	@GetMapping("userList")
	public ResponseEntity<List<User>> AllUsers(){
		return ResponseEntity.ok(userCrud.getAllUsers());
	}

	@GetMapping("user/byID/{id}")
	public ResponseEntity<User> getUserById(@PathVariable String id){
		
		return ResponseEntity.ok(userCrud.getUserByID(id));
	}

	@GetMapping("userByName")
	public ResponseEntity<User> getUserByName(@RequestBody User user) throws Exception{
		
		return ResponseEntity.ok(userCrud.getUserByName(user.getName()));
	}

	@PostMapping("createUser")
    public ResponseEntity<User> hello(@RequestBody User user) {
      return ResponseEntity.ok(userCrud.createUser(user));
    }

	@PutMapping("userLogin")
    public ResponseEntity<User> userLogin(@RequestBody User user) throws Exception{
        
        return ResponseEntity.ok(userCrud.logIn(user.getName(),user.getPassword()));
    }

	    
	@PutMapping("userUpdate/{id}")
	public ResponseEntity<User> updateByID(@PathVariable String id,@RequestBody User user){
		return ResponseEntity.ok(userCrud.updateUser(id,user));
	}

		
	@DeleteMapping("userProfile/deleteInsurance/{id}/{InsuranceID}")
	public ResponseEntity<User> deleteInsurance(@PathVariable String id,@PathVariable String InsuranceID){
		return ResponseEntity.ok(userCrud.deleteInsurance(id,InsuranceID));
	}


	@DeleteMapping("userProfile/userDelete/{id}")
	public String deleteByID(@PathVariable String id){
		
		userCrud.deletUserByID(id);
		return String.format("USER DELETED");
	}

	
}
