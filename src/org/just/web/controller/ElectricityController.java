package org.just.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.just.dao.UserDao;
import org.just.entity.Major;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ElectricityController {
	@Resource
	private UserDao userDao;
	@RequestMapping("/electricity.form")
	public String excute(Model model){
		try{
			List<Major> list7=userDao.findElectricityGraduate();
			model.addAttribute("electricity",list7);
			int j =0;
			for (int i = 0; i < list7.size(); i++) {
				 j =list7.get(i).getElectricity_graduate_count()+j;
			}    
			  model.addAttribute("gr_count",j);
			List<Major> list8=userDao.findElectricityEmployement();
			model.addAttribute("electricity_gra", list8);
			int q =0;
			for (int i = 0; i < list8.size(); i++) {
				 q =list8.get(i).getElectricity_employment_count()+q;
			}    
			  model.addAttribute("empCount",q);
			return "electricity";			
		}catch(Exception e){
			e.printStackTrace();
			return "error" ;
		}

}
	}



