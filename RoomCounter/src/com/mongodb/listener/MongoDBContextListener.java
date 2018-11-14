package com.mongodb.listener;

import java.net.UnknownHostException;
import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.mongodb.client.*;
import com.mongodb.client.MongoClient;
import com.mongodb.*;

@WebListener
public class MongoDBContextListener implements ServletContextListener {
	
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		MongoClient mongo = (MongoClient)sce.getServletContext().getAttribute("MONGO_CLIENT");
		mongo.close();
		System.out.println("MongoClient closed successfully");
	}
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		ServletContext ctx = sce.getServletContext();
		String add = "mongodb://" + ctx.getInitParameter("MONGODB_HOST") + ":" +
				Integer.parseInt(ctx.getInitParameter("MONGODB_PORT"));
		MongoClient mongo = MongoClients.create(add);
		System.out.println("MongoClient init success");
		sce.getServletContext().setAttribute("MONGO_CLIENT",  mongo);
	}
	

}
