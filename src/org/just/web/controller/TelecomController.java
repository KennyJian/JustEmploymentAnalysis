package org.just.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.just.dao.UserDao;
import org.just.entity.Major;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TelecomController {
	@Resource
	private UserDao userDao;
	@RequestMapping("/telecom.form")
	public String excute(Model model){
		try{
			List<Major> list3=userDao.findTelecomGraduate();
			model.addAttribute("telecom",list3);
			int j =0;
			for (int i = 0; i < list3.size(); i++) {
				 j =list3.get(i).getTelecom_graduate_count()+j;
			}    
			  model.addAttribute("gr_count",j);
			List<Major> list4=userDao.findTelecomEmployement();
			model.addAttribute("telecom_gra", list4);
			int q =0;
			for (int i = 0; i < list4.size(); i++) {
				 q =list4.get(i).getTelecom_employment_count()+q;
			}    
			  model.addAttribute("empCount",q);
			return "telecom";			
		}catch(Exception e){
			e.printStackTrace();
			return "error" ;
		}

}
	}


