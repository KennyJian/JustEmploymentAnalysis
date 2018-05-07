package org.just.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.just.dao.UserDao;
import org.just.entity.Major;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EducationController {
	@Resource
	private UserDao userDao;
	@RequestMapping("/education.form")
	public String excute(Model model){
		try{
			List<Major> list13=userDao.findEducationGraduate();
			model.addAttribute("education",list13);
			int j =0;
			for (int i = 0; i < list13.size(); i++) {
				 j =list13.get(i).getEducation_graduate_count()+j;
			}    
			  model.addAttribute("gr_count",j);
			List<Major> list14=userDao.findEducationEmployement();
			model.addAttribute("education_gra", list14);
			int p =0;
			for (int i = 0; i < list14.size(); i++) {
				 p =list14.get(i).getEducation_employment_count()+p;
			}    
			  model.addAttribute("empCount",p);
			return "education";			
		}catch(Exception e){
			e.printStackTrace();
			return "error" ;
		}

}
	}
