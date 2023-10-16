package severlet;

import enity.KhachHang;
import enity.NSX;
import enity.SanPham;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import respository.KhachHangRes;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "KhachHangServlet", value = {
        "/showAddKH",
        "/addKH",
        "/detailKH",
        "/removeKH",
        "/updateKH"
})
public class KhachHangServlet extends HttpServlet {
    KhachHangRes resKH = new KhachHangRes();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/showAddKH")) {
            request.getRequestDispatcher("trang/khachhang/addKH.jsp").forward(request, response);
        } else if (uri.contains("/removeKH")) {
            String id= request.getParameter("id");
            KhachHang kh = resKH.getById(id);
            resKH.delete(kh);
            response.sendRedirect("/khachhang");
        }else if (uri.contains("detailKH")) {
            String id= request.getParameter("id");
            KhachHang kh = resKH.getById(id);
            request.setAttribute("listUD", kh);
            request.getRequestDispatcher("trang/khachhang/detailKH.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri= request.getRequestURI();
        if(uri.contains("addKH")){
            KhachHang kh = new KhachHang();
            try {
                BeanUtils.populate(kh,request.getParameterMap());
                resKH.add(kh);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/khachhang");
        } else if (uri.contains("updateKH")) {
            KhachHang kh = new KhachHang();
            try {
                BeanUtils.populate(kh,request.getParameterMap());
                resKH.update(kh);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/khachhang");
        }
    }
}
