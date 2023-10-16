package severlet;

import enity.NSX;
import enity.SanPham;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import respository.NSXRes;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "NSXServlet", value = {
        "/showAddNSX",
        "/addNSX",
        "/detailNSX",
        "/removeNSX",
        "/updateNSX"
})
public class NSXServlet extends HttpServlet {
    NSXRes resSX = new NSXRes();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/showAddNSX")) {
            request.getRequestDispatcher("trang/nsx/addNSX.jsp").forward(request, response);
        } else if (uri.contains("removeNSX")) {
            String id= request.getParameter("id");
            NSX sx = resSX.getById(id);
            resSX.delete(sx);
            response.sendRedirect("/nsx");
        }else if (uri.contains("detailNSX")) {
            String id= request.getParameter("id");
            NSX sx = resSX.getById(id);
            request.setAttribute("listUD", sx);
            request.getRequestDispatcher("trang/nsx/detailNSX.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri= request.getRequestURI();
        if(uri.contains("addNSX")){
            NSX sx = new NSX();
            try {
                BeanUtils.populate(sx,request.getParameterMap());
                resSX.add(sx);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/nsx");
        } else if (uri.contains("updateNSX")) {
            NSX sx = new NSX();
            try {
                BeanUtils.populate(sx,request.getParameterMap());
                resSX.update(sx);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/nsx");
        }
    }
}
