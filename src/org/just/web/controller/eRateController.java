package org.just.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.just.dao.UserDao;
import org.just.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class eRateController {

	@Resource
	private UserDao userDao;

	@RequestMapping("/eRate.form")
	public String excute(Model model){
		try{
			List<User> list=userDao.findAll();
			model.addAttribute("users", list);
			return "eRate";			
		}catch(Exception e){
			e.printStackTrace();
			return "error" ;
		}

	}
}
