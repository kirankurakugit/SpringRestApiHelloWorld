package com.zensar.controllers;   
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.zensar.beans.Birthday;
import com.zensar.dao.BirthdayRemainderDao;  
@Controller  
public class BirthDayController {  
    @Autowired  
    BirthdayRemainderDao dao;  
           
    @RequestMapping(value="/user/{username}/{birthdaydate}",method = RequestMethod.PUT)  
    public String save(@PathVariable String username,@PathVariable String birthdaymsg,@ModelAttribute("birthdayate") Birthday birthdaydate,ModelMap model){  
        
    	LocalDate today = LocalDate.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MMM-yyyy");
    	LocalDate birthday= LocalDate.parse(birthdaymsg,formatter);
    	      
        LocalDate nextBDay = birthday.withYear(today.getYear());

    	//If your birthday has occurred this year already, add 1 to the year.
    	   if (nextBDay.isBefore(today) || nextBDay.isEqual(today)) {
    	         nextBDay = nextBDay.plusYears(1);
    	        
   	        Period p = Period.between(today, nextBDay);
    	    long p2 = ChronoUnit.DAYS.between(today, nextBDay);
    	       
    	     birthdaymsg="There ae "+p.getMonths() +"months,and"+ p.getDays() +"days until your next birthday";
    	      
    	        }	            
    	      else {
    	      birthdaymsg="Today is your Birthday";
    	           		
    	           }
    	        	        
    	  dao.save(birthdaydate);
    	  model.addAttribute("message",birthdaymsg);
         return "redirect:/userlist"; 
        }  
       /* It displays object data into form for the given username.  
     * The @PathVariable puts URL data into variable.*/  
     @RequestMapping(value="/user/{username}",method = RequestMethod.GET) 
     public String getuser(@PathVariable String username, Model m){  
        Birthday birthdate=dao.getUserName(username);  
        m.addAttribute("command",birthdate);
        return "userlist";  
    }  
    
       
}  