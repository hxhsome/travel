package cn.hxh.travel.web.oldServlet;

import cn.hxh.travel.service.UserService;
import cn.hxh.travel.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/activeUserServlet")
public class ActiveUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        if(code!=null){
            UserService service = new UserServiceImpl();
            boolean flag = service.active(code);
            //3.判断标记
            String msg = null;
            if(flag){
                //激活成功
                msg="激活成功，请登录<a href ='login.html'>登陆</a>";
                response.getWriter().write(msg);
            }else{
                //激活失败
                msg = "激活失败，请联系管理员!";
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write(msg);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
