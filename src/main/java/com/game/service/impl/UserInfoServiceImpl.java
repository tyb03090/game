package com.game.service.impl;

import java.util.List;
import java.util.Map;

import com.game.dao.UserInfoDAO;
import com.game.dao.impl.UserInfoDAOImpl;
import com.game.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {
	private UserInfoDAO uiService = new UserInfoDAOImpl();

	@Override
	public List<Map<String, String>> selectUserInfoList(Map<String, String> user) {
		return uiService.selectUserInfoList(user);
	}

	@Override
	public Map<String, String> selectUserInfoOne(String uiNum) {
		return uiService.selectUserInfoOne(uiNum);
	}

	@Override
	public int insertUserInfo(Map<String, String> user) {
		return uiService.insertUserInfo(user);
	}

	@Override
	public int updateUserInfo(Map<String, String> user) {
		return uiService.updateUserInfo(user);
	}

	@Override
	public int deleteUserInfo(String uiNum) {
		return uiService.deleteUserInfo(uiNum);
	}

	@Override
	public Map<String, String> login(String uiId) {
		return uiService.selectUserInfoById(uiId);
	}

}
