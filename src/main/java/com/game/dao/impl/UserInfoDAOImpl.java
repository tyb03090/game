package com.game.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.common.DBCon;
import com.game.dao.UserInfoDAO;

public class UserInfoDAOImpl implements UserInfoDAO {

	@Override
	public List<Map<String, String>> selectUserInfoList(Map<String, String> user) {
		String sql = "SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD,\r\n" + "UI_IMG_PATH, UI_DESC, UI_BIRTH,\r\n"
				+ "CREDAT, CRETIM,\r\n" + "LMODAT, LMOTIM FROM user_info WHERE 1=1";

		List<Map<String, String>> userInfoList = new ArrayList<>();

		try (Connection con = DBCon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						Map<String, String> uiMap = new HashMap<>();

						uiMap.put("uiNum", rs.getString("UI_NUM"));
						uiMap.put("uiName", rs.getString("UI_NAME"));
						uiMap.put("uiId", rs.getString("UI_ID"));
						uiMap.put("uiPwd", rs.getString("UI_PWD"));
						uiMap.put("uiImgPath", rs.getString("UI_IMG_PATH"));
						uiMap.put("uiDesc", rs.getString("UI_DESC"));
						uiMap.put("uiBirth", rs.getString("UI_BIRTH"));
						uiMap.put("credat", rs.getString("CREDAT"));
						uiMap.put("cretim", rs.getString("CRETIM"));
						uiMap.put("lmodat", rs.getString("LMODAT"));
						uiMap.put("lmotim", rs.getString("LMOTIM"));

						userInfoList.add(uiMap);
					}

				}
			}
		} catch (Exception e) {

		}
		return userInfoList;
	}

	@Override
	public Map<String, String> selectUserInfoOne(String uiNum) {
		String sql = "SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD,\r\n" + "UI_IMG_PATH, UI_DESC, UI_BIRTH,\r\n"
				+ "CREDAT, CRETIM,\r\n" + "LMODAT, LMOTIM FROM user_info WHERE 1=1 AND UI_NUM = ?";

		try (Connection con = DBCon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, uiNum);
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						Map<String, String> uiMap = new HashMap<>();

						uiMap.put("uiNum", rs.getString("UI_NUM"));
						uiMap.put("uiName", rs.getString("UI_NAME"));
						uiMap.put("uiId", rs.getString("UI_ID"));
						uiMap.put("uiPwd", rs.getString("UI_PWD"));
						uiMap.put("uiImgPath", rs.getString("UI_IMG_PATH"));
						uiMap.put("uiDesc", rs.getString("UI_DESC"));
						uiMap.put("uiBirth", rs.getString("UI_BIRTH"));
						uiMap.put("credat", rs.getString("CREDAT"));
						uiMap.put("cretim", rs.getString("CRETIM"));
						uiMap.put("lmodat", rs.getString("LMODAT"));
						uiMap.put("lmotim", rs.getString("LMOTIM"));

						return uiMap;
					}
				}
			}
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public int insertUserInfo(Map<String, String> user) {
		String sql = "INSERT INTO user_info(\r\n" + "UI_NAME, UI_ID, UI_PWD,\r\n" + "UI_DESC, UI_BIRTH,\r\n"
				+ "CREDAT, CRETIM,\r\n" + "LMODAT, LMOTIM)\r\n" + "VALUES(\r\n" + "?, ?, ?,\r\n" + "?, ?,\r\n"
				+ "DATE_FORMAT(NOW(), '%Y%m%d'), DATE_FORMAT(NOW(), '%H%i%s'),\r\n"
				+ "DATE_FORMAT(NOW(), '%Y%m%d'), DATE_FORMAT(NOW(), '%H%i%s'))";

		try (Connection con = DBCon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, user.get("uiName"));
				ps.setString(2, user.get("uiId"));
				ps.setString(3, user.get("uiPwd"));
				ps.setString(4, user.get("uiDesc"));
				ps.setString(5, user.get("uiBirth"));

				return ps.executeUpdate();
			}
		} catch (Exception e) {

		}
		return 0;
	}

	@Override
	public int updateUserInfo(Map<String, String> user) {
		String sql = "UPDATE user_info\r\n" + "SET UI_NAME = ?, UI_ID = ?, UI_PWD = ?,\r\n"
				+ "UI_DESC = ?, UI_BIRTH = ?\r\n" + "WHERE UI_NUM = ?";

		try (Connection con = DBCon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, user.get("uiName"));
				ps.setString(2, user.get("uiId"));
				ps.setString(3, user.get("uiPwd"));
				ps.setString(4, user.get("uiDesc"));
				ps.setString(5, user.get("uiBirth"));
				ps.setString(6, user.get("uiNum"));

				return ps.executeUpdate();
			}
		} catch (Exception e) {

		}
		return 0;
	}

	@Override
	public int deleteUserInfo(String uiNum) {
		String sql = "DELETE FROM user_info WHERE UI_NUM = ?";

		try (Connection con = DBCon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, uiNum);
				return ps.executeUpdate();
			}
		} catch (Exception e) {

		}
		return 0;
	}

	@Override
	public Map<String, String> selectUserInfoById(String uiId) {
		String sql = "SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD,\r\n" + "UI_IMG_PATH, UI_DESC, UI_BIRTH,\r\n"
				+ "CREDAT, CRETIM,\r\n" + "LMODAT, LMOTIM, ACTIVE FROM user_info WHERE 1=1 AND UI_ID = ?";

		try (Connection con = DBCon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, uiId);
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						Map<String, String> uiMap = new HashMap<>();

						uiMap.put("uiNum", rs.getString("UI_NUM"));
						uiMap.put("uiName", rs.getString("UI_NAME"));
						uiMap.put("uiId", rs.getString("UI_ID"));
						uiMap.put("uiPwd", rs.getString("UI_PWD"));
						uiMap.put("uiImgPath", rs.getString("UI_IMG_PATH"));
						uiMap.put("uiDesc", rs.getString("UI_DESC"));
						uiMap.put("uiBirth", rs.getString("UI_BIRTH"));
						uiMap.put("credat", rs.getString("CREDAT"));
						uiMap.put("cretim", rs.getString("CRETIM"));
						uiMap.put("lmodat", rs.getString("LMODAT"));
						uiMap.put("lmotim", rs.getString("LMOTIM"));
						uiMap.put("active", rs.getString("ACTIVE"));

						return uiMap;
					}
				}
			}
		} catch (Exception e) {

		}
		return null;
	}

	public static void main(String[] args) {
		UserInfoDAOImpl uiDao = new UserInfoDAOImpl();

		System.out.println(uiDao.selectUserInfoList(null));
		System.out.println(uiDao.selectUserInfoOne("2"));

//		Map<String, String> map = new HashMap<>();
//
//		map.put("uiName", "a");
//		map.put("uiId", "b");
//		map.put("uiPwd", "c");
//		map.put("uiDesc", "d");
//		map.put("uiBirth", "19990103");
//
//		int result = uiDao.insertUserInfo(map);

//		Map<String, String> map = new HashMap<>();
//
//		map.put("uiName", "김용빈");
//		map.put("uiId", "xodus1228");
//		map.put("uiPwd", "jess0418");
//		map.put("uiDesc", "김용준 형");
//		map.put("uiBirth", "19951228");
//		map.put("uiNum", "5");
//
//		int result = uiDao.updateUserInfo(map);

//		int result = uiDao.deleteUserInfo("13");

//		System.out.println("Result : " + result);

		System.out.println(uiDao.selectUserInfoById("123"));

	}

}
