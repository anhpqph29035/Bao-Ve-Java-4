package severlet;

import enity.SanPham;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import respository.SanPhamRes;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

@WebServlet(name = "SanPhamServlet", value = {
        "/showAddSP",
        "/addSP",
        "/detailSP",
        "/removeSP",
        "/updateSP"
})
public class SanPhamServlet extends HttpServlet {
    SanPhamRes resSP  =  new SanPhamRes();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/showAddSP")) {
            request.getRequestDispatcher("trang/sanpham/addSanPham.jsp").forward(request, response);
        } else if (uri.contains("removeSP")) {
            String id= request.getParameter("id");
            SanPham sp = resSP.getById(id);
            resSP.delete(sp);
            response.sendRedirect("/product");
        }else if (uri.contains("detailSP")) {
            String id= request.getParameter("id");
            SanPham sp = resSP.getById(id);
            request.setAttribute("listUD", sp);
            request.getRequestDispatcher("trang/sanpham//detailSanPham.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri= request.getRequestURI();
        if(uri.contains("addSP")){
            SanPham sp = new SanPham();
            try {
                BeanUtils.populate(sp,request.getParameterMap());
                resSP.add(sp);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/product");
        } else if (uri.contains("updateSP")) {
            SanPham sp = new SanPham();
            try {
                BeanUtils.populate(sp,request.getParameterMap());
                resSP.update(sp);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/product");
        }
    }

    public String setCC(HttpServletRequest request) {
        String value = "";
        Cookie ck[] = request.getCookies();
        if (ck != null) {
            for (Cookie cookie : ck) {
                if (cookie.getName().equals("tenKH")) {
                    value = cookie.getValue();
                }
            }
        }
        return value;
    }
}
