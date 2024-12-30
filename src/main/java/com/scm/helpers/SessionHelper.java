package com.scm.helpers;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

import jakarta.servlet.http.HttpSession;

@Component
public class SessionHelper {

    public static  void removeMessage(){
        try
        {
            HttpSession session = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
            session.removeAttribute("message");            
            // System.out.println("session Removed");

        }
        catch(Exception e)
        {
            // System.out.println("error in replacing");
            e.printStackTrace();
        }
    }
}
