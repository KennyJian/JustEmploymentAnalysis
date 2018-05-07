package org.just.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.just.dao.UserDao;
import org.just.entity.College;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CollegeController {
	@Resource
	private UserDao userDao;
	@RequestMapping("/college.form")
	public String excute(Model model){
		try{
			List<College> list15=userDao.findBusinessData();
			model.addAttribute("college",list15);
			List<College> list16=userDao.findEducationData();
			model.addAttribute("college2",list16);
			List<College> list17=userDao.findShipData();
			model.addAttribute("college3",list17);
			List<College> list18=userDao.findGoldData();
			model.addAttribute("college4",list18);
			List<College> list19=userDao.findElectricityData();
			model.addAttribute("college5",list19);
			List<College> list20=userDao.findTelecomData();
			model.addAttribute("college6",list20);
			
			
			return "college";			
		}catch(Exception e){
			e.printStackTrace();
			return "error" ;
		}

}
	}
