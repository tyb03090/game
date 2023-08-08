package com.game.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.game.common.CommonView;
import com.game.service.GameInfoService;
import com.game.service.impl.GameInfoServiceImpl;
import com.google.gson.Gson;

@WebServlet("/game-info/*")
public class GameInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GameInfoService giService = new GameInfoServiceImpl();
	private Gson gson = new Gson();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = CommonView.getCmd(request);
		String json = "";
		if("list".equals(cmd)) {
			json = gson.toJson(giService.selectGameInfoList(null));
		}else if("view".equals(cmd)) {
			
		}
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
