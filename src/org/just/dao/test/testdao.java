package org.just.dao.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.just.dao.UserDao;
import org.just.dao.impl.UserDaoImpl;
import org.just.entity.AllDirection;
import org.just.entity.GradAndEmpCount;
import net.sf.json.JSONArray;

public class testdao {

	public static void main(String[] args) {
		// TODO Auto-generated meth od stub

//		UserDao userdao=new UserDaoImpl();
//		List<User> list=userdao.findAll();
//		System.out.println(list.size());
//		for(User user:list){
//			System.out.println(user.getCollege()+"---"+user.getName());
//		}
	/*	UserDaoImpl userdao1=new UserDaoImpl();
		List<Result> list1=userdao1.getCount1("job_position");
		for(Result result:list1){
			System.out.println(result.getThekey()+":"+result.getValue());
		}*/
//		UserDao userdao=new UserDaoImpl();
//		 HashMap<String,Integer> list =userdao.getStudentInCount();//获取生源地统计(前台地图)
		/* for(Result result:list){
				System.out.println(result.getThekey()+":"+result.getValue());
			}
	*/
			/**
			 * 测试根据学院计算毕业人数和就业人数机器比例
			 */
			 UserDao userdao=new UserDaoImpl();
			 List<GradAndEmpCount> list=userdao.findGradandEmpByCollege("机电与动力工程学院");		 
			 for(GradAndEmpCount g:list){
				 System.out.println(g.getCollege()+" "+g.getMajor()+" "+g.getGraduate_count()+" "+g.getEmployment_count()+" "+g.getScale());
			 }
		     String json =JSONArray.fromObject(list).toString();
		     System.out.println(json);
			 /**
			  * 测试获取测试汇总及其比例
			  */
			 List<AllDirection> list2=userdao.findAllDirection();
			 for(AllDirection all:list2){
				 System.out.println(all.getCollege()+" "+all.getMajor()+" "+all.getGraudation()+" "+all.getSchool()+" "+all.getSchool_scale()+" "+all.getAbroad()+" "+all.getAbroad_scale()+" "+all.getWork()+" "+all.getWork_scale()+" "+all.getAgile()+" "+all.getAgile_scale());
			 }
			 
			 /**
			  * 测试江苏省各市人数获取
			  */
			 HashMap<String,Integer> map=userdao.getToJiangSuCount();
			 Iterator iter=map.entrySet().iterator();
			 while(iter.hasNext()){
				 Map.Entry entry = (Map.Entry) iter.next();
				 Object key = entry.getKey();
				 Object val = entry.getValue();
				 System.out.println(key+" "+val);
			 }
		}

}
