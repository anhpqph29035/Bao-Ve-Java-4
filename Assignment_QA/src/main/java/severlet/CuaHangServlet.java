package severlet;

import enity.ChucVu;
import enity.CuaHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import respository.CuaHangRes;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "CuaHangServlet", value = {
        "/showAddCH",
        "/addCH",
        "/detailCH",
        "/removeCH",
        "/updateCH"
})
public class CuaHangServlet extends HttpServlet {
    CuaHangRes resCH = new CuaHangRes();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/showAddCH")) {
            request.getRequestDispatcher("trang/cuahang/addCuaHang.jsp").forward(request, response);
        } else if (uri.contains("removeCH")) {
            String id= request.getParameter("id");
            CuaHang ch = resCH.getById(id);
            resCH.delete(ch);
            response.sendRedirect("/cuahang");
        }else if (uri.contains("detailCH")) {
            String id= request.getParameter("id");
            CuaHang ch = resCH.getById(id);
            request.setAttribute("listUD", ch);
            request.getRequestDispatcher("trang/cuahang/detailCuaHang.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri= request.getRequestURI();
        if(uri.contains("addCH")){
            CuaHang ch = new CuaHang();
            try {
                BeanUtils.populate(ch,request.getParameterMap());
                resCH.add(ch);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/cuahang");
        } else if (uri.contains("updateCH")) {
            CuaHang ch = new CuaHang();
            try {
                BeanUtils.populate(ch,request.getParameterMap());
                resCH.update(ch);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/cuahang");
        }
    }
}
