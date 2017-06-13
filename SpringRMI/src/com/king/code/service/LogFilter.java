package com.king.code.service;


import java.io.BufferedReader;
import java.io.IOException;  
import java.io.InputStreamReader;
import java.net.URLDecoder;

import javax.servlet.Filter;  
import javax.servlet.FilterChain;  
import javax.servlet.FilterConfig;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
import javax.servlet.http.HttpServletRequest;  
  
public class LogFilter implements Filter {    
      
    public FilterConfig config;    
     
    public void init(FilterConfig config) throws ServletException {    
        System.out.println("begin do the log filter!");    
        this.config = config;    
    }  
    
    public void doFilter(ServletRequest request, ServletResponse resopnse, FilterChain chain) throws IOException, ServletException {    
    	System.out.println("before the log filter!");    
    	// 将请求转换成HttpServletRequest 请求    
    	HttpServletRequest hreq = (HttpServletRequest) request;    
    	// 记录日志    
    	System.out.println("Log Filter已经截获到用户的请求的地址:"+hreq.getServletPath() );  
    	//使用apache的httpcomponents 的post请求时:formparams.add(new BasicNameValuePair("key","value"));  也只能从这里获取到!
    	BufferedReader br = new BufferedReader(new InputStreamReader(hreq.getInputStream(),"iso8859-1")); 
    	String line = null;
    	StringBuilder streamSB = new StringBuilder();
    	while ((line = br.readLine()) != null) {
    		streamSB.append(line);
    	}
    	System.out.println("我是服务器,通过request.getInputStream()读取的参数:\n" + streamSB.toString());
    	String decode = URLDecoder.decode(streamSB.toString(), "UTF-8");
    	System.out.println("我是服务器,通过request.getInputStream()读取的参数:\n" + decode);
    	try {    
    		// Filter 只是链式处理，请求依然转发到目的地址。    
    		chain.doFilter(hreq, resopnse);    
    	} catch (Exception e) {    
    		e.printStackTrace();    
    	}    
    	System.out.println("after the log filter!");    
    }    
    
    public void destroy() {    
        this.config = null;    
        System.out.println("end do the logging filter!");  
    }    
     
 }  