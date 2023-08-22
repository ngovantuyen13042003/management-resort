package svt.st.managementresot.service.impl;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CookieService {
    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpServletResponse response;

//    reading cookie from request
//    @param name cookies name need read
//    @return object cookie read or null if not exist
    public Cookie get(String name){
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for (Cookie cookie : cookies){
                if(cookie.getName().equalsIgnoreCase(name)){
                    return  cookie;
                }
            }
        }
        return  null;
    }


    public  String getValue(String name) {
        Cookie cookie = get(name);
        if (cookie != null){
            return  cookie.getValue();
        }
        return null;
    }

//    create and send cookie to client
    public Cookie add(String name, String value, int hours) {
        Cookie cookie    = new Cookie(name, value);
        cookie.setMaxAge(hours*60*60);
        cookie.setPath("/");
        response.addCookie(cookie);
        return  cookie;
    }

//    delete cookies of client
    public  void remove(String name) {
        add(name , "", 0);
    }



}
