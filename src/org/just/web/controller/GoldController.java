package org.just.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.just.dao.UserDao;
import org.just.entity.Major;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoldController {
	@Resource
	private UserDao userDao;
	@RequestMapping("/gold.form")
	public String excute(Model model){
		try{
			List<Major> list9=userDao.findGoldGraduate();
			model.addAttribute("gold",list9);
			int j =0;
			for (int i = 0; i < list9.size(); i++) {
				 j =list9.get(i).getGold_graduate_count()+j;
			}    
			  model.addAttribute("gr_count",j);
			List<Major> list10=userDao.findGoldEmployement();
			model.addAttribute("gold_gra", list10);
			int q =0;
			for (int i = 0; i < list10.size(); i++) {
				 q =list10.get(i).getGold_employment_count()+q;
			}    
			  model.addAttribute("empCount",q);
			return "gold";			
		}catch(Exception e){
			e.printStackTrace();
			return "error" ;
		}

}
	}
