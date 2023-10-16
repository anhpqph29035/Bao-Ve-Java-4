package severlet;

import enity.KhachHang;
import enity.SanPhamCT;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import respository.KhachHangRes;
import respository.SanPhamCTRes;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoginServlet", value = {
        "/login",
        "/loginto",
        "/logout"
})
public class LoginServlet extends HttpServlet {
    SanPhamCTRes resCT = new SanPhamCTRes();
    KhachHangRes resKH = new KhachHangRes();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/login")) {
            request.getRequestDispatcher("web/login.jsp").forward(request, response);
        }  else if (uri.contains("/logout")) {
            Cookie ck = new Cookie("idKH", "");
            Cookie ck1 = new Cookie("tenKH", "");
            ck.setMaxAge(0);
            ck1.setMaxAge(0);
            response.addCookie(ck);
            response.addCookie(ck1);
            ArrayList<SanPhamCT> list = resCT.getAll();
            request.setAttribute("listSPCT", list);
            response.sendRedirect("/home");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/loginto")) {
            String ma = request.getParameter("maKH");
            String pass = request.getParameter("passKH");
            KhachHang kh = resKH.checkLogin(ma, pass);
            if (ma.equalsIgnoreCase(kh.getMaKH()) && pass.equals(kh.getMatKhauKH())) {
                request.setAttribute("Khach", kh.getTenKH());
                request.setAttribute("logout", "Logout");
                Cookie idKH = new Cookie("idKH", kh.getIdKH());
                Cookie tenKH = new Cookie("tenKH", kh.getTenKH());
                idKH.setMaxAge(10 * 60 * 60);
                tenKH.setMaxAge(10 * 60 * 60);
                response.addCookie(idKH);
                response.addCookie(tenKH);
                ArrayList<SanPhamCT> list = resCT.getAll();
                request.setAttribute("listSPCT", list);
                response.sendRedirect("/home");
            } else {
                String loi = "Sai tên đăng nhập hoặc mật khẩu";
                request.setAttribute("loii", loi);
                request.getRequestDispatcher("web/login.jsp").forward(request, response);
            }
        }
    }
}
