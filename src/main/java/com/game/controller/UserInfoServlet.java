package com.game.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.game.common.CommonView;
import com.game.service.UserInfoService;
import com.game.service.impl.UserInfoServiceImpl;
import com.google.gson.Gson;


@WebServlet("/user-info/*")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoService uiService = new UserInfoServiceImpl();
	private Gson gson = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = CommonView.getCmd(request);
		String json = "";
		if("list".equals(cmd)) {
			json = gson.toJson(uiService.selectUserInfoList(null));
		}else if("view".equals(cmd) || "update".equals(cmd)) {
		}
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = CommonView.getCmd(request);
		
		Map<String, String> user = new HashMap<>();
		user.put("uiName", request.getParameter("uiName"));
		user.put("uiId", request.getParameter("uiId"));
		user.put("uiPwd", request.getParameter("uiPwd"));
		user.put("uiDesc", request.getParameter("uiDesc"));
		if(request.getParameter("uiBirth") != null) {
			user.put("uiBirth", request.getParameter("uiBirth").replace("-", ""));
		}
		
		if("insert".equals(cmd)) {
			int result = uiService.insertUserInfo(user);
			request.setAttribute("msg", "등록 성공!");
			request.setAttribute("url", "/user-info/list");
			if(result != 1) {
				request.setAttribute("msg", "등록 실패...");
				request.setAttribute("url", "/user-info/insert");
			}
		}else if("update".equals(cmd)) {
			user.put("uiNum", request.getParameter("uiNum"));
			int result = uiService.updateUserInfo(user);
			
			request.setAttribute("msg", "수정 성공!");
			request.setAttribute("url", "/user-info/view?uiNum=" + request.getParameter("uiNum"));
			if(result != 1) {
				request.setAttribute("msg", "수정 실패...");
				request.setAttribute("url", "/user-info/update?uiNum=" + request.getParameter("uiNum"));
			}
		}else if("delete".equals(cmd)) {
			int result = uiService.deleteUserInfo(request.getParameter("uiNum"));
			
			request.setAttribute("msg", "삭-제");
			request.setAttribute("url", "/user-info/list");
			
			if(result != 1) {
				request.setAttribute("msg", "삭-제를 삭-제");
				request.setAttribute("url", "/user-info/view?uiNum=" + request.getParameter("uiNum"));
			}
		}else if("login".equals(cmd)) {
			request.setAttribute("msg", "뭐가 틀렸을까~요?");
			request.setAttribute("url", "/user-info/login");
			
			HttpSession session = request.getSession();
			String uiId = request.getParameter("uiId");
			String uiPwd = request.getParameter("uiPwd");
			Map<String, String> ui = uiService.login(uiId);
			if(ui != null) {
				String dbUiPwd = ui.get("uiPwd");
				if(uiPwd.equals(dbUiPwd)) {
					request.setAttribute("msg", "로그인 성공!");
					request.setAttribute("url", "/");
					
					session.setAttribute("user", ui);
				}
			}
		}
		CommonView.forwardMessage(request, response);
	}

}
