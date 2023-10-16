package severlet;

import enity.ChucVu;
import enity.MauSac;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import respository.ChucVuRes;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "ChucVuServlet", value = {
        "/showAddCV",
        "/addCV",
        "/detailCV",
        "/removeCV",
        "/updateCV"
})
public class ChucVuServlet extends HttpServlet {
    ChucVuRes resCV = new ChucVuRes();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/showAddCV")) {
            request.getRequestDispatcher("trang/chucvu/addChucVu.jsp").forward(request, response);
        } else if (uri.contains("removeCV")) {
            String id= request.getParameter("id");
            ChucVu cv = resCV.getById(id);
            resCV.delete(cv);
            response.sendRedirect("/chucvu");
        }else if (uri.contains("detailCV")) {
            String id= request.getParameter("id");
            ChucVu cv = resCV.getById(id);
            request.setAttribute("listUD", cv);
            request.getRequestDispatcher("trang/chucvu/detailChucVu.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri= request.getRequestURI();
        if(uri.contains("addCV")){
            ChucVu cv = new ChucVu();
            try {
                BeanUtils.populate(cv,request.getParameterMap());
                resCV.add(cv);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/chucvu");
        } else if (uri.contains("updateCV")) {
            ChucVu cv = new ChucVu();
            try {
                BeanUtils.populate(cv,request.getParameterMap());
                resCV.update(cv);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/chucvu");
        }
    }
}
