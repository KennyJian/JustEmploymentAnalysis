package org.just.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.just.dao.UserDao;
import org.just.entity.Major;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShipController {
	@Resource
	private UserDao userDao;
	@RequestMapping("/ship.form")
	public String excute(Model model){
		try{
			List<Major> list11=userDao.findShipGraduate();
			model.addAttribute("ship",list11);
			int j =0;
			for (int i = 0; i < list11.size(); i++) {
				 j =list11.get(i).getShip_graduate_count()+j;
			}    
			  model.addAttribute("gr_count",j);
			List<Major> list12=userDao.findShipEmployement();
			model.addAttribute("ship_gra", list12);
			int q =0;
			for (int i = 0; i < list12.size(); i++) {
				 q =list12.get(i).getShip_employment_count()+q;
			}    
			  model.addAttribute("empCount",q);
			return "ship";			
		}catch(Exception e){
			e.printStackTrace();
			return "error" ;
		}

}
	}
