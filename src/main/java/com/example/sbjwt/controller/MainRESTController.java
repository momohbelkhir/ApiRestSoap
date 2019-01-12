package com.example.sbjwt.controller;

import java.awt.List;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com._4d.www.namespace._default.A_WebServiceRPCProxy;
@RestController
public class MainRESTController {
     
     private ArrayList<User> users = new ArrayList<User>();
    
 
    @RequestMapping("/")
    @ResponseBody
    public String welcome() {
        return "Welcome to Spring Boot + REST + JWT Example.";
    }
 
    
    @RequestMapping(value = "/GetUsers", //
    method = RequestMethod.GET, //
    produces = { MediaType.APPLICATION_JSON_VALUE, //
            MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public String test() throws RemoteException {
    	A_WebServiceRPCProxy soap=new A_WebServiceRPCProxy();
		System.out.println("http://46.21.205.149:8083/4DSOAP/");
		
		
	   System.out.println("getUsers :\n"+soap.getUsers()+"**");
    	

       
        return soap.getUsers();
    }
  
    
    @RequestMapping(value = "/GetEvents", //
    method = RequestMethod.GET, //
    produces = { MediaType.APPLICATION_JSON_VALUE, //
            MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public String GetEvents() throws RemoteException {
    	A_WebServiceRPCProxy soap=new A_WebServiceRPCProxy();
		System.out.println("http://46.21.205.149:8083/4DSOAP/");

	    System.out.println("getEvenements :\n"+soap.getEvenements()+"**");
   
        return soap.getEvenements();
    }
    
   
    @RequestMapping(value = "/AddEvents", //
    method = RequestMethod.GET, //
    produces = { MediaType.APPLICATION_JSON_VALUE, //
            MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public String AddEvents() throws RemoteException, InterruptedException {
    	A_WebServiceRPCProxy soap=new A_WebServiceRPCProxy();
		System.out.println("http://46.21.205.149:8083/4DSOAP/");

	    System.out.println("AddEvents :\n"+soap.eventAdd("30/12/2018", "Api soap ok", "Paris"
	    		              , "14:00:00", "20:00:00", "5")+"**");
	    Thread.sleep(500);
        return soap.getEvenements();
    }
   
    
    @RequestMapping(value = "/EventAdd", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public String EventAdd(@RequestBody EventInfo event) throws RemoteException, InterruptedException {
    	A_WebServiceRPCProxy soap=new A_WebServiceRPCProxy();
		

	    soap.eventAdd(event.getDateevent(), event.getObjetvent(), event.getLieuevent(), 
	    		      event.getHdebvent(), event.getHfinvent(), event.getStruserid());
	    Thread.sleep(500);
        return soap.getEvenements();
    }
    

    
    @RequestMapping(value = "/getEventsByDate", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public String getEventsByDate() throws RemoteException, InterruptedException {
    	A_WebServiceRPCProxy soap=new A_WebServiceRPCProxy();
    
               System.out.println(soap.getEvenementsByDates(5, "01/12/2018", "30/12/2018"));
        return soap.getEvenementsByDates(5, "01/12/2018", "30/12/2018");
    }
    
    
    @RequestMapping(value = "/getEventsByUser/{idUser}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public String getEventsByUser(@PathVariable int idUser) throws RemoteException, InterruptedException {
    	A_WebServiceRPCProxy soap=new A_WebServiceRPCProxy();
    
        return soap.getEvenementsByUser(idUser);
    }


	public ArrayList<User> getUsers() {
		return users;
	}


	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
    
    
    
   
 
}