package com.boot.dubbo.client.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.dubbo.server.api.UserService;
import com.boot.dubbo.server.model.User;

//@Controller
@RestController
public class WebController {

	@Autowired
	private UserService userService;
	 
	 
	@RequestMapping("/home")
    public String home() {
        return "spring boot dubbo client!";
    }
	
	@RequestMapping("/getId")
	public String getById(@RequestParam String id,Model m){
		try {
			//userService=SpringBeanHelper.getBean("userService");
			//log.info("id:"+id+"|userService:"+userService);
			User user=this.userService.getUserById(id);
			m.addAttribute("user", user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/test";
	}
	
	@RequestMapping("/getById/{id}")
	public User getById(@PathVariable("id") String id){
		try {
			System.out.println("===========userService:"+userService+"===================");
			User user=this.userService.getUserById(id);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
