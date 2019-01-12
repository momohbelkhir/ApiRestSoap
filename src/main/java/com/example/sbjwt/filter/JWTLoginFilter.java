package com.example.sbjwt.filter;

import java.io.IOException;
import java.util.Collections;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.sbjwt.controller.MainRESTController;
import com.example.sbjwt.controller.User;
import com.example.sbjwt.service.TokenAuthenticationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
 
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {
	@Autowired
	MainRESTController mainRest;
 
    public JWTLoginFilter(String url, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
    }
 
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
 
        String username = request.getParameter("username");
        String password = request.getParameter("password");
 
        System.out.printf("JWTLoginFilter.attemptAuthentication: username/password= %s,%s", username, password);
        System.out.println();
 
        return getAuthenticationManager()
                .authenticate(new UsernamePasswordAuthenticationToken(username, password, Collections.emptyList()));
    }
 
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
 
        System.out.println("JWTLoginFilter.successfulAuthentication:");
 
        // Write Authorization to Headers of Response.
        TokenAuthenticationService.addAuthentication(response, authResult.getName());
 
        String authorizationString = response.getHeader("Authorization");
       // mainRest.getUsers().add(new User(authResult.getName(),authorizationString));
        
      
        
        System.out.println("AuthResult.getName()=" + authResult.getName());
        System.out.println("Authorization String=" + authorizationString);
       /* try {
			System.out.println("HACH : ."+encrypt("m","key")+".");
			System.out.println("Decrypt : "+decrypt(encrypt("m","key"),"key"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    }
    
    public static String encrypt(String strClearText,String strKey) throws Exception{
    	String strData="";
    	
    	try {
    		SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
    		Cipher cipher=Cipher.getInstance("Blowfish");
    		cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
    		byte[] encrypted=cipher.doFinal(strClearText.getBytes());
    		strData=new String(encrypted);
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new Exception(e);
    	}
    	return strData;
    }
    public static String decrypt(String strEncrypted,String strKey) throws Exception{
    	String strData="";
    	
    	try {
    		SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
    		Cipher cipher=Cipher.getInstance("Blowfish");
    		cipher.init(Cipher.DECRYPT_MODE, skeyspec);
    		byte[] decrypted=cipher.doFinal(strEncrypted.getBytes());
    		strData=new String(decrypted);
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new Exception(e);
    	}
    	return strData;
    }
  
 
}
