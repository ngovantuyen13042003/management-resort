package svt.st.managementresot.service.impl;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;

@Service
public class ParamService {
    @Autowired
    HttpServletRequest request;

    // đọc chuổi giá trị của tham số
    // @param name: name of param
    // @peam defaultValue: giá trị mặc định
    // return:  giá trị của tham số hoặc giá trị mặc định nếu không tồn tại
    public  String getString(String name, String defaultValue) {
        String value = request.getParameter(name);
        return  value != null ? value:defaultValue;
    }
    // đọc chuổi giá trị của tham số
    // @param name: name of param
    // @peam defaultValue: giá trị mặc định
    // return:  giá trị của tham số hoặc giá trị mặc định nếu không tồn tại
    public  int getInt(String name, int defaultValue) {
        String value =  getString(name,String.valueOf(defaultValue));
        return Integer.parseInt(value);
    }

    public  Double getDouble(String name, Double defaultValue) {
        String value =  getString(name,String.valueOf(defaultValue));
        return Double.parseDouble(value);
    }

    public  Boolean getBoolean(String name, Boolean defaultValue) {
        String value =  getString(name,String.valueOf(defaultValue));
        return Boolean.parseBoolean(value);
    }




}
