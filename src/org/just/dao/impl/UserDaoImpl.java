package org.just.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.just.dao.UserDao;
import org.just.entity.Major;
import org.just.entity.AllDirection;
import org.just.entity.College;
import org.just.entity.GradAndEmpCount;
import org.just.entity.Result;
import org.just.entity.User;
import org.just.util.SqlSessionUtil;
import org.springframework.stereotype.Repository;
@Repository
public class UserDaoImpl implements UserDao{

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionUtil.getSession();
		List<User> list=session.selectList("findAll");
		session.close();
		return list;
	}

	@Override
	public HashMap<String, Integer> getCount(String type) {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionUtil.getSession();
		HashMap<String,Integer> map=new HashMap<>();
		List<Result> list=session.selectList("getCount",type);
		for(Result result:list){
			if(result.getThekey()==null){
				if(result.getValue()!=0){
					map.put("其他", result.getValue());
				}
				continue;
			}
			map.put(result.getThekey(),result.getValue());
		}
		return map;
	}
	
	//用作测试是否成功获取数据存入list当中
	public List<Result> getCount1(String type) {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionUtil.getSession();
		List<Result> list=session.selectList("getCount",type);
		session.close();
		return list;
	}

	@Override
	public HashMap<String, Integer> getSexCount() {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionUtil.getSession();
		HashMap<String,Integer> map=new HashMap<>();
		List<Result> list=session.selectList("getSexCount");
		for(Result result:list){
			if(result.getThekey()==null){
				if(result.getValue()!=0){
					map.put("其他", result.getValue());
				}
				continue;
			}
			String index ="男".equals(result.getThekey())?"male":"female";//如果对键有硬性的非中文要求可使用该行
			map.put(result.getThekey(),result.getValue());
		}
		return map;
	}

	@Override
	public HashMap<String, Integer> getCollegeCount() {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionUtil.getSession();
		HashMap<String,Integer> map=new HashMap<>();
		List<Result> list=session.selectList("getCollegeCount");
		for(Result result:list){
			if(result.getThekey()==null){
				if(result.getValue()!=0){
					map.put("其他", result.getValue());
				}
				continue;
			}
			String index=null;
			switch(result.getThekey()) {
			case "公共教育学院":
				index = "Public_Education";
				break;
			case "冶金与材料工程学院":
				index = "Metallurgy_Materials";
				break;
			case "商学院":
				index = "Business";
				break;
			case "机电与动力工程学院":
				index = "Mechatronic_Power";
				break;
			case "电气与信息工程学院":
				index = "Electrical_Information";
				break;
			case "船舶与建筑工程学院":
				index = "Ship_Building";
				break;
			default :
				index = " ";					
			}				
			map.put(result.getThekey(),result.getValue());
		}
		return map;
	}

	@Override
	public HashMap<String, Integer> getNationCount() {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionUtil.getSession();
		HashMap<String,Integer> map=new HashMap<>();
		List<Result> list=session.selectList("getNationCount");
		for(Result result:list){
			if(result.getThekey()==null){
				if(result.getValue()!=0){
					map.put("其他", result.getValue());
				}
				continue;
			}
			String index=null;
			switch(result.getThekey()) {
			case "汉族":
				index = "Han";
				break;
			case "回族":
				index = "Hui";
				break;
			case "满族":
				index = "Manchu";
				break;
			case "蒙古族":
				index = "Mongol";
				break;
			default :
				index = "";					
			}				
			map.put(result.getThekey(),result.getValue());
		}
		return map;
	}

	@Override
	public HashMap<String, Integer> getEmployedCount() {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionUtil.getSession();
		HashMap<String,Integer> map=new HashMap<>();
		List<Result> list=session.selectList("getEmployedCount");
		for(Result result:list){
			if(result.getThekey()==null){
				if(result.getValue()!=0){
					map.put("其他", result.getValue());
				}
				continue;
			}
			String index=null;
			index ="待就业".equals(result.getThekey())?"Notemployed":"employed";//如果对键有硬性的非中文要求可使用该行
			if(map.containsKey(index)) {//因为数据库中就业分为好多种，这里如果已就业键被创建则循环加起来所有的已就业类型
				map.put(index,map.get(index)+result.getValue());
			}else {
				map.put(index,result.getValue());
			}
		}
		return map;
	}

	@Override
	public HashMap<String, Integer> getEmployStatusCount() {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionUtil.getSession();
		HashMap<String,Integer> map=new HashMap<>();
		List<Result> list=session.selectList("getEmployStatusCount");
		for(Result result:list){
			if(result.getThekey()==null){
				if(result.getValue()!=0){
					map.put("其他", result.getValue());
				}
				continue;
			}
			String index=null;
			switch(result.getThekey()) {
			case "出国":
				index = "Go_abroad";
				break;
			case "升学":
				index = "Further_study";
				break;
			case "就业":
				index = "Employed";
				break;
			case "待就业":
				index = "NotEmployment";
				break;
			case "灵活就业":
				index = "Flexible employment";
				break;
			case "自主创业":
				index = "Entrepreneurship";
				break;
			default :
				index = "";					
			}			
			map.put(result.getThekey(),result.getValue());
		}
		return map;
	}

	@Override
	public HashMap<String, Integer> getActualaddressCount() {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionUtil.getSession();
		HashMap<String,Integer> map=new HashMap<>();
		List<Result> list=session.selectList("getActualaddressCount");
		for(Result result:list){
			if(result.getThekey()==null){
				if(result.getValue()!=0){
					map.put("其他", result.getValue());
				}
				continue;
			}
			String swap=result.getThekey();
			int firstIndex = swap.indexOf("省");
			if(firstIndex<0)firstIndex = swap.indexOf("市");

			String provincesOrCities = swap.substring(0,firstIndex);
			if(map.containsKey(provincesOrCities)) {
				map.put(provincesOrCities, map.get(provincesOrCities)+result.getValue());	
			}else {
				map.put(provincesOrCities,result.getValue());
			}
		}
		return map;
	}
	@Override
	public HashMap<String, Integer> getStudentInCount() {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionUtil.getSession();
		HashMap<String,Integer> map=new HashMap<>();
		List<Result> list=session.selectList("getStudentInCount");
		for(Result result:list){
			if(result.getThekey()==null){
				if(result.getValue()!=0){
					map.put("其他", result.getValue());
				}
				continue;
			}
			String swap=result.getThekey();
			int firstIndex = swap.indexOf("省");
			if(firstIndex<0)firstIndex = swap.indexOf("市");

			String provincesOrCities = swap.substring(0,firstIndex);
			if(map.containsKey(provincesOrCities)) {
				map.put(provincesOrCities, map.get(provincesOrCities)+result.getValue());	
			}else {
				map.put(provincesOrCities,result.getValue());
			}
		}
		return map;
	}
	
	@Override
	public List<Major> findCollegeGraduate() {
		SqlSession session=SqlSessionUtil.getSession();
		List<Major> list1=session.selectList("findCollegeGraduate");
		session.close();
		return list1;
	}

	@Override
	public List<Major> findCollegeEmployement() {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionUtil.getSession();
		List<Major> list2=session.selectList("findCollegeEmployement");
		session.close();
		return list2;
	}
	@Override
	public List<Major> findBusinessGraduate() {
		SqlSession session=SqlSessionUtil.getSession();
		List<Major> list3=session.selectList("findBusinessGraduate");
		session.close();
		return list3;
	}

	@Override
	public List<Major> findBusinessEmployement() {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionUtil.getSession();
		List<Major> list4=session.selectList("findBusinessEmployement");
		session.close();
		return list4;
	}
	@Override
	public List<Major> findTelecomGraduate() {
		SqlSession session=SqlSessionUtil.getSession();
		List<Major> list5=session.selectList("findTelecomGraduate");
		session.close();
		return list5;
	}

	@Override
	public List<Major> findTelecomEmployement(){
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionUtil.getSession();
		List<Major> list6=session.selectList("findTelecomEmployement");
		session.close();
		return list6;
	}
	@Override
	public List<Major> findElectricityGraduate() {
		SqlSession session=SqlSessionUtil.getSession();
		List<Major> list7=session.selectList("findElectricityGraduate");
		session.close();
		return list7;
	}

	@Override
	public List<Major> findElectricityEmployement() {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionUtil.getSession();
		List<Major> list8=session.selectList("findElectricityEmployement");
		session.close();
		return list8;
	}
	@Override
	public List<Major> findGoldGraduate() {
		SqlSession session=SqlSessionUtil.getSession();
		List<Major> list9=session.selectList("findGoldGraduate");
		session.close();
		return list9;
	}

	@Override
	public List<Major> findGoldEmployement() {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionUtil.getSession();
		List<Major> list10=session.selectList("findGoldEmployement");
		session.close();
		return list10;
	}
	@Override
	public List<Major> findShipGraduate() {
		SqlSession session=SqlSessionUtil.getSession();
		List<Major> list11=session.selectList("findShipGraduate");
		session.close();
		return list11;
	}

	@Override
	public List<Major> findShipEmployement() {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionUtil.getSession();
		List<Major> list12=session.selectList("findShipEmployement");
		session.close();
		return list12;
	}
	@Override
	public List<Major> findEducationGraduate() {
		SqlSession session=SqlSessionUtil.getSession();
		List<Major> list13=session.selectList("findEducationGraduate");
		session.close();
		return list13;
	}

	@Override
	public List<Major> findEducationEmployement() {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionUtil.getSession();
		List<Major> list14=session.selectList("findEducationEmployement");
		session.close();
		return list14;
	}
	@Override
	public List<College> findBusinessData() {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionUtil.getSession();
		List<College> list15=session.selectList("findBusinessData");
		session.close();
		return list15;
	}
	@Override
	public List<College> findEducationData() {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionUtil.getSession();
		List<College> list16=session.selectList("findEducationData");
		session.close();
		return list16;
	}
	@Override
	public List<College> findShipData() {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionUtil.getSession();
		List<College> list17=session.selectList("findShipData");
		session.close();
		return list17;
	}
	@Override
	public List<College> findGoldData() {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionUtil.getSession();
		List<College> list18=session.selectList("findGoldData");
		session.close();
		return list18;
	}
	@Override
	public List<College> findElectricityData() {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionUtil.getSession();
		List<College> list19=session.selectList("findElectricityData");
		session.close();
		return list19;
	}
	@Override
	public List<College> findTelecomData() {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionUtil.getSession();
		List<College> list20=session.selectList("findTelecomData");
		session.close();
		return list20;
	}
	
	@Override
	public List<GradAndEmpCount> findGradandEmpByCollege(String college) {
		SqlSession session=SqlSessionUtil.getSession();
		List<GradAndEmpCount> list21=session.selectList("findGradAndEmpByCollege",college);
		session.close();
		return list21;
	}

	@Override
	public List<AllDirection> findAllDirection() {		
		SqlSession session=SqlSessionUtil.getSession();
		List<AllDirection> list22=session.selectList("findAllDirection");
		session.close();
		return list22;
	}

	@Override
	public HashMap<String, Integer> getToJiangSuCount() {
		SqlSession session=SqlSessionUtil.getSession();
		HashMap<String,Integer> map=new HashMap<>();
		List<Result> list=session.selectList("getToJiangSuCount");
		for(Result result:list){
			String swap=result.getThekey();
			int firstIndex = swap.indexOf("省");

			String provincesOrCities = swap.substring(firstIndex+1,swap.length());
			map.put(provincesOrCities,result.getValue());	
		}
		return map;
	}

	@Override
	public List<GradAndEmpCount> findGradandEmpByCollegeAll() {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionUtil.getSession();
		List<GradAndEmpCount> list23=session.selectList("findGradAndEmpByCollegeAll");
		session.close();
		return list23;
	}

}
