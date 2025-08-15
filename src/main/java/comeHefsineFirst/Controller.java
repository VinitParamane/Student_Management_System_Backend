package comeHefsineFirst;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
@CrossOrigin
@RestController
public class Controller {
	@Autowired
	StudentRepo studentRepo;
	@Autowired
	UserRepo userRepo;
	
	@RequestMapping("login{username}")
	public int login(@PathVariable String username,@RequestBody String password) {
		int count=userRepo.countByUsername(username);
		if(count==0)
			return 2;//wrong username
		else if(count>1)
			return 3;//multiple accounts with same username
		else {
			User user=userRepo.findByUsername(username);
			
			if(user.password.equals(password))
				return 1;//login
			else
				return 4;//password wrong
		}
		
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping("get")
	public List<Student> get(){
		return studentRepo.findAll();
		}
		
		@RequestMapping("save")
		public Student save(@RequestBody Student student)
		{
			try {
				 Student dbStudent=studentRepo.save(student);
				return dbStudent;
			}
			catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
			
		@RequestMapping("delete{id}")	
		public int delete(@PathVariable int id)
		{
			try {
				studentRepo.deleteById(id);
				return 1;//Done
				
			}
           catch(Exception e){
	             e.printStackTrace();
	             return 2;//exception
	             }
			
         }
		
		
	    
		
		
		
		
		
			
}
	
