package org.just.web.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.just.dao.UserDao;
import org.just.entity.AllDirection;
import org.just.entity.GradAndEmpCount;
import org.just.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ajaxStatistics")
public class AjaxStatisticsController {
	@Resource(name="userDaoImpl")  //指定使用哪个实现类
	private UserDao userDao;
	
	@RequestMapping("getAll.form")
	public @ResponseBody List<User> showAll(){//供json获取所有数据
		return userDao.findAll();
	}
	
	@RequestMapping("sexCount")
	public @ResponseBody HashMap<String,Integer> showSexCount(){//供json获取性别统计
		return userDao.getSexCount();
	}
	
	@RequestMapping("collegeCount")
	public @ResponseBody HashMap<String,Integer> showCollegeCount(){//供json获取学院分布
		return userDao.getCount("college");
	}
	
	@RequestMapping("studentInCount")
	public @ResponseBody HashMap<String,Integer> showStudentInCount(){//供json获取生源地分布
		return userDao.getStudentInCount();
	}	
	
	@RequestMapping("nationCount")
	public @ResponseBody HashMap<String,Integer> showNationCount(){//供json获取民族分布
		System.out.println("1");
		return userDao.getCount("nation");
	}
	
	@RequestMapping("employedCount")
	public @ResponseBody HashMap<String,Integer> showEmployedCount(){//供json获取就业率数据
		return userDao.getEmployedCount();
	}
	
	@RequestMapping("employStatusCount")
	public @ResponseBody HashMap<String,Integer> showEmployStatusCount(){//供json获取就业状态(去处)
		return userDao.getCount("employment_status");
	}	
	

	@RequestMapping("actualaddressCount")
	public @ResponseBody HashMap<String,Integer> showActualaddressCount(){//供json获取就业状态(去处)
		return userDao.getActualaddressCount();
	}	
	@RequestMapping("jobPosition")
	public @ResponseBody HashMap<String,Integer> showJobPositionCount(){//供json获取就业行业
		return userDao.getCount("job_position");
	}	
	
	@RequestMapping("findGradandEmpByCollege")
	public @ResponseBody List<GradAndEmpCount> showGradandEmpByCollege(HttpServletRequest req){//供json获取所有数据
		String college=req.getParameter("college");				
		return userDao.findGradandEmpByCollege(college);
	}
	@RequestMapping("findGradandEmpByCollegeAll")
	public @ResponseBody List<GradAndEmpCount> showGradandEmpByCollegeAll(){//供json获取所有数据
		return userDao.findGradandEmpByCollegeAll();
	}

	@RequestMapping("findAllDirection")
	public @ResponseBody List<AllDirection> showAllDirection(){//供json获取所有数据
		return userDao.findAllDirection();
	}
	
	@RequestMapping("getToJiangSuCount")
	public @ResponseBody HashMap<String,Integer> showToJiangSuCount(){//供json获取就业行业
		return userDao.getToJiangSuCount();
	}	
}
