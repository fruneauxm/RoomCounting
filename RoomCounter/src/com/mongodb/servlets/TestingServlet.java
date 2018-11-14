package com.mongodb.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.models.Room;
import com.mongodb.DBInterface.*;

@WebServlet("/test")
public class TestingServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws
			ServletException, IOException {
			
		 String sessionName = request.getParameter("name");
		 
		if(sessionName == null) {
			//error
			System.out.println("Error adding, values null");
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/Index.jsp");
			rd.forward(request, response);
		}else {
			MongoClient mongo = (MongoClient) request.getServletContext()
					.getAttribute("MONGO_CLIENT");
			
			//Test prints -- This would be where we do verification and adding to db
			System.out.println(sessionName);
			
			
			List<Room> dummy = new ArrayList<Room>();
			Room r1 = new Room();
			r1.setName(sessionName);
			r1.setCapacity("2");
			dummy.add(r1);
			
			request.setAttribute("Data", dummy);
			
			


			
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Index.jsp");
			rd.forward(request, response);
			
		}
		
	
	}

}
