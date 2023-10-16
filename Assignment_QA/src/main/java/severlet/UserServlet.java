package severlet;

import enity.ChucVu;
import enity.CuaHang;
import enity.SanPham;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import respository.ChucVuRes;
import respository.CuaHangRes;
import respository.KhachHangRes;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "UserServlet", value ={
        "/cuahang",
        "/khachhang",
        "/chucvu"
})
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        ChucVuRes resCV = new ChucVuRes();
        CuaHangRes resCH = new CuaHangRes();
        KhachHangRes resKH = new KhachHangRes();
        if (uri.contains("/cuahang")) {
            ArrayList<CuaHang> listCH = resCH.getAll();
            request.setAttribute("listCH",listCH);
            request.getRequestDispatcher("trang/cuahang/listCuaHang.jsp").forward(request, response);
        }else if (uri.contains("/khachhang")) {
            request.setAttribute("listKH",resKH.getAll());
            request.getRequestDispatcher("trang/khachhang/listKH.jsp").forward(request, response);
        }else if(uri.contains("/chucvu")) {
            ArrayList<ChucVu> listCV = resCV.getAll();
            request.setAttribute("listCV",listCV);
            request.getRequestDispatcher("trang/chucvu/listChucVu.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
