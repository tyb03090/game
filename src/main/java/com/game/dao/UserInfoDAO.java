package com.game.dao;

import java.util.List;
import java.util.Map;

public interface UserInfoDAO {

	List<Map<String, String>> selectUserInfoList(Map<String, String> user);

	Map<String, String> selectUserInfoOne(String uiNum);

	int insertUserInfo(Map<String, String> user);
	
	int updateUserInfo(Map<String, String> user);
	
	int deleteUserInfo(String uiNum);
	
	Map<String, String> selectUserInfoById(String uiId);
}
