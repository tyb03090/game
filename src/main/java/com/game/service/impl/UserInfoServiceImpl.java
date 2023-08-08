package com.game.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.game.common.MybatisSqlSessionFactory;
import com.game.dao.UserInfoDAO;
import com.game.dao.impl.UserInfoDAOImpl;
import com.game.mapper.UserInfoMapper;
import com.game.service.UserInfoService;
import com.game.vo.UserInfoVO;

public class UserInfoServiceImpl implements UserInfoService {
	private UserInfoDAO uiService = new UserInfoDAOImpl();
	private SqlSessionFactory ssf = MybatisSqlSessionFactory.getSqlSessionFactory();

	@Override
	public List<UserInfoVO> selectUserInfoList(UserInfoVO userInfo) {
		try(SqlSession session = ssf.openSession()){
			UserInfoMapper uiMapper = session.getMapper(UserInfoMapper.class);
			return uiMapper.selectUserInfoList(userInfo);
		}catch(Exception e) {
			throw e;
		}
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
