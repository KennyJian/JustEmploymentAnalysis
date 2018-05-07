package org.just.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.just.dao.UserDao;
import org.just.entity.Major;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class allCollegeController {
	@Resource
	private UserDao userDao;
	@RequestMapping("/allCollege.form")
	public String excute(Model model){
		try{
			List<Major> list1=userDao.findCollegeGraduate();
			model.addAttribute("college",list1);
			int m =0;
			for (int i = 0; i < list1.size(); i++) {
				 m =list1.get(i).getGraduate_count()+m;
			}    
			  model.addAttribute("gr_count",m);
			List<Major> list2=userDao.findCollegeEmployement();
			model.addAttribute("college_gra", list2);
			int n =0;
			for (int i = 0; i < list1.size(); i++) {
				 n =list2.get(i).getEmployment_count()+n;
			}    
			  model.addAttribute("empCount",n);
			return "allCollege";			
		}catch(Exception e){
			e.printStackTrace();
			return "error" ;
		}

}
	}



