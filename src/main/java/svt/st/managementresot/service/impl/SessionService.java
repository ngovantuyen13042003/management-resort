package svt.st.managementresot.service.impl;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    @Autowired
    HttpSession session;

    // read value of attribute in session
    public <T> T get(String name){
        return (T) session.getAttribute(name);
    }

    // change or create new attribute in session
    public void  set(String name, Object value) {
        session.setAttribute(name, value);
    }

    // delete attribute in session
    public  void remove(String name) {
        session.removeAttribute(name);
    }


}
