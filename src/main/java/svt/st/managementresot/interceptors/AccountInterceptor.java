package svt.st.managementresot.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import svt.st.managementresot.entity.employee.Employee;
import svt.st.managementresot.service.EmployeeService;

@Component
public class AccountInterceptor implements HandlerInterceptor {
    @Autowired
    private EmployeeService employeeService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Xóa cache của SecurityContextHolder trước khi lấy thông tin mới
//        SecurityContextHolder.clearContext();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication!=null){
            Employee employee = employeeService.findByUserName(authentication.getName());
            request.setAttribute("employee", employee);
        }
        return true;
    }
}
