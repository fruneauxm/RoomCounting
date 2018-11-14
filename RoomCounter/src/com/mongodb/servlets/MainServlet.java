package com.mongodb.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.mongodb.client.MongoClient;
import com.mongodb.models.Room;
import com.mongodb.models.TimeSlot;
import com.mongodb.utilities.Util;

public class MainServlet extends HttpServlet {
	
	@Override
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)

	        throws ServletException, IOException {
		MongoClient mongo = (MongoClient) request.getServletContext()
				.getAttribute("MONGO_CLIENT");
		
		//GETTING ALL THE TIME SLOTS FROM THE DATABASE
		Util utilTime = new Util(mongo, "TimeSlots");
		List<TimeSlot> AllTimeSlots = utilTime.readAllTimeSlots();
		
		//GETTING ALL THE ROOMS FROM THE DATBASE
		Util utilRoom = new Util(mongo, "Rooms");
		List<Room> AllRooms = utilRoom.readAllRooms();
		
		

		//SHOWING THE LSIT ON THE WEBSITE
		request.setAttribute("timeSlots", AllTimeSlots);
		request.setAttribute("rooms", AllRooms);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Creation Menu.jsp");
		rd.forward(request, response);
		
	       
	    }
}
