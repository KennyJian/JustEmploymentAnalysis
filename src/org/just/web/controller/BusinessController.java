package org.just.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.just.dao.UserDao;
import org.just.entity.Major;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BusinessController {
	@Resource
	private UserDao userDao;
	@RequestMapping("/business.form")
	public String excute(Model model){
		try{
			List<Major> list3=userDao.findBusinessGraduate();
			model.addAttribute("business",list3);
			int j =0;
			for (int i = 0; i < list3.size(); i++) {
				 j =list3.get(i).getBusiness_graduate_count()+j;
			}    
			  model.addAttribute("gr_count",j);
			List<Major> list4=userDao.findBusinessEmployement();
			model.addAttribute("business_gra", list4);
			int q =0;
			for (int i = 0; i < list4.size(); i++) {
				 q =list4.get(i).getBusiness_employment_count()+q;
			}    
			  model.addAttribute("empCount",q);
			return "business";			
		}catch(Exception e){
			e.printStackTrace();
			return "error" ;
		}

}
	}



