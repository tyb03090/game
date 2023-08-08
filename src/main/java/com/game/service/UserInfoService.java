package com.game.service;

import java.util.List;
import java.util.Map;

import com.game.vo.UserInfoVO;

public interface UserInfoService {

	List<UserInfoVO> selectUserInfoList(UserInfoVO user);
	
	Map<String, String> selectUserInfoOne(String uiNum);
	
	int insertUserInfo(Map<String, String> user);
	
	int updateUserInfo(Map<String, String> user);
	
	int deleteUserInfo(String uiNum);
	
	Map<String, String> login(String uiId);
}
