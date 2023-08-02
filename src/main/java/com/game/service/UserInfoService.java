package com.game.service;

import java.util.List;
import java.util.Map;

public interface UserInfoService {

	List<Map<String, String>> selectUserInfoList(Map<String, String> user);
	
	Map<String, String> selectUserInfoOne(String uiNum);
	
	int insertUserInfo(Map<String, String> user);
	
	int updateUserInfo(Map<String, String> user);
	
	int deleteUserInfo(String uiNum);
	
	Map<String, String> login(String uiId);
}
