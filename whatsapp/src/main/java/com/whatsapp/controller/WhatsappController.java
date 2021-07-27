package com.whatsapp.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.whatsapp.dao.WhatsAppDAO;
import com.whatsapp.dao.WhatsAppDAOInterface;
import com.whatsapp.entity.WhatsappUser;

public class WhatsappController implements WhatsappControllerinterface {
	
	private BufferedReader br;
	private WhatsAppDAOInterface wdao;
	
	public WhatsappController() {
		br=new BufferedReader(new InputStreamReader(System.in));
		wdao=new WhatsAppDAO();
	}
	

	public void createProfileController()throws Exception {
		System.out.println("enter your name");
		String name=br.readLine();
		
		System.out.println("enter your password");
		String password=br.readLine();
		
		System.out.println("enter your email");
		String email=br.readLine();
		
		System.out.println("enter your address");
		String address=br.readLine();
		
		WhatsappUser ws=new WhatsappUser();
		ws.setName(name);
		ws.setAddress(address);
		ws.setEmail(email);
		ws.setPassword(password);
		
		
		int i=wdao.createProfileDAO(ws);//we shoud transfer data from layer to layer via DTO(data transfer object) design pattern
		
		if(i>0) {
			System.out.println("registration success");
		}
		else {
			System.out.println("registration fail");
		}
		
		
		
		
	}

	public void viewProfileController() throws Exception{
		System.out.println("enter your email to view profile");
		String email=br.readLine();
		
		WhatsappUser ws=new WhatsappUser();
		ws.setEmail(email);
		
		WhatsappUser ww=wdao.viewProfile(ws);
		
		if(ww!=null) {
			System.out.println("Name is "+ww.getName());
			System.out.println("Password is "+ww.getPassword());
			System.out.println("Email is "+ww.getEmail());
			System.out.println("Address is "+ww.getAddress());
		}
		else {
			System.out.println("no profile available for given email");
		}
		
		
		
		
	}

	public void deleteProfileController() throws Exception{
		System.out.println("Enter your name to delete your profile");
		String name = br.readLine();
		WhatsappUser ws=new WhatsappUser();
		ws.setName(name);
		int i=wdao.deleteProfileDAO(ws);//we shoud transfer data from layer to layer via DTO(data transfer object) design pattern
		
		if(i>0) {
			System.out.println("Profile deleted Successfully");
		}
		else {
			System.out.println("No profile found");
		}
		
	}

	public void viewAllProfileController() throws Exception{
		
		List<WhatsappUser> ww1=wdao.viewAllProfile();
		
		for(WhatsappUser ww:ww1) {
			System.out.println("******************************");
			System.out.println("Name is "+ww.getName());
			System.out.println("Password is "+ww.getPassword());
			System.out.println("Email is "+ww.getEmail());
			System.out.println("Address is "+ww.getAddress());
			System.out.println("******************************");
		}
		
		
		
		
	}

	public void searchProfileController() throws Exception{
		System.out.println("Enter your email and password to search your profile");
		String email = br.readLine();
		String password = br.readLine();
		WhatsappUser ws=new WhatsappUser();
		ws.setEmail(email);
		
		WhatsappUser ww=wdao.searchProfile(ws);
		
		if(ww!=null) {
			System.out.println("Name is "+ww.getName());
			System.out.println("ID is "+ww.getPassword());
			//System.out.println("Password is "+ww.getPassword());
			//System.out.println("Email is "+ww.getEmail());
			System.out.println("Address is "+ww.getAddress());
		}
		else {
			System.out.println("no profile available for given email");
		}
		
		
	
		
	}

	public void editProfileController() throws Exception{
		System.out.println("Enter your name to update your profile");
		String name = br.readLine();
		WhatsappUser ws=new WhatsappUser();
		ws.setName(name);
		int i=wdao.editProfileDAO(ws);//we shoud transfer data from layer to layer via DTO(data transfer object) design pattern
		
		if(i>0) {
			System.out.println("Profile updated Successfully");
		}
		else {
			System.out.println("No profile found");
		}
		
	}
		
		
	}


