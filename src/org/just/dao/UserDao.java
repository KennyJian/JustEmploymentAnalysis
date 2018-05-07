package org.just.dao;


import java.util.HashMap;
import java.util.List;

import org.just.entity.AllDirection;
import org.just.entity.College;
import org.just.entity.GradAndEmpCount;
import org.just.entity.Major;
import org.just.entity.User;
public interface UserDao {

	public List<User> findAll();
	public HashMap<String,Integer> getCount(String type);
	//上面的方法下面若干方法的总结方法，但是只能获得中文索引，需要英文请使用下面各方法
	//(生源地方法只有中文键值，下面实现是中文的；通过本方法获取下面各方法的字符串为：
	//getCount("sex")|getCount("college")|getCount("nation")|getCount("employment_category")|getCount("employment_status")	
	public HashMap<String,Integer> getSexCount();//获取性别统计(前台饼图)
	public HashMap<String,Integer> getCollegeCount();//获取学院分布统计(前台柱状图)
	public HashMap<String,Integer> getNationCount();//获取民族分布统计(前台柱状图)
	public HashMap<String,Integer> getEmployedCount();//获取就业统计(前台表格展示)
	public HashMap<String,Integer> getEmployStatusCount();//获取就业状态（就业去向）统计(前台饼图)
	public HashMap<String,Integer> getStudentInCount();//获取生源地统计(前台地图)	
	public List<Major> findCollegeGraduate();   //获取专业毕业人数
	public List<Major> findCollegeEmployement();  //获取专业对应就业人数
	public List<Major> findBusinessGraduate();   //获取专业毕业人数
	public List<Major> findBusinessEmployement();  //获取专业对应就业人数
	public List<Major> findTelecomGraduate();   //获取专业毕业人数
	public List<Major> findTelecomEmployement();  //获取专业对应就业人数
	public List<Major> findElectricityGraduate();   //获取专业毕业人数
	public List<Major> findElectricityEmployement();  //获取专业对应就业人数
	public List<Major> findGoldGraduate();   //获取专业毕业人数
	public List<Major> findGoldEmployement();  //获取专业对应就业人数
	public List<Major> findShipGraduate();   //获取专业毕业人数
	public List<Major> findShipEmployement();  //获取专业对应就业人数
	public List<Major> findEducationGraduate();   //获取专业毕业人数
	public List<Major> findEducationEmployement();  //获取专业对应就业人数
	public List<College>findBusinessData();//获取商学院的数据
	public List<College>findEducationData();//获取公共教育学院的数据
	public List<College>findShipData();//获取船舶学院的数据
	public List<College>findGoldData();//获取冶金学院的数据
	public List<College>findElectricityData();//获取电气学院的数据
	public List<College>findTelecomData();//获取机动学院的数据
	public HashMap<String,Integer> getActualaddressCount();//获取生源地统计(表格)
	
	public List<GradAndEmpCount> findGradandEmpByCollege(String college);//根据学院查询该学院的所有专业中毕业人数和就业人数的情况
	public List<GradAndEmpCount> findGradandEmpByCollegeAll();//根据学院查询该学院的所有专业中毕业人数和就业人数的情况汇总
	public List<AllDirection> findAllDirection();//获取各个学院各个专业去向及比例
	public HashMap<String,Integer> getToJiangSuCount();
 }
