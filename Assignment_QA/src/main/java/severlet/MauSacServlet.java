package severlet;

import enity.MauSac;
import enity.NSX;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import respository.MauSacRes;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "MauSacServlet", value = {
        "/showAddMS",
        "/addMS",
        "/detailMS",
        "/removeMS",
        "/updateMS"
})
public class MauSacServlet extends HttpServlet {
    MauSacRes resMS = new MauSacRes();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/showAddMS")) {
            request.getRequestDispatcher("trang/mausac/addMauSac.jsp").forward(request, response);
        } else if (uri.contains("removeMS")) {
            String id= request.getParameter("id");
            MauSac ms = resMS.getById(id);
            resMS.delete(ms);
            response.sendRedirect("/colors");
        }else if (uri.contains("detailMS")) {
            String id= request.getParameter("id");
            MauSac ms = resMS.getById(id);
            request.setAttribute("listUD", ms);
            request.getRequestDispatcher("trang/mausac/detailMauSac.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri= request.getRequestURI();
        if(uri.contains("addMS")){
            MauSac ms = new MauSac();
            try {
                BeanUtils.populate(ms,request.getParameterMap());
                resMS.add(ms);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/colors");
        } else if (uri.contains("updateMS")) {
            MauSac ms = new MauSac();
            try {
                BeanUtils.populate(ms,request.getParameterMap());
                resMS.update(ms);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/colors");
        }
    }
}
