package severlet;

import enity.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import respository.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProductServlet", value = {
        "/nsx",
        "/product",
        "/colors",
        "/dongSP",
        "/CTSP"
})
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        SanPhamRes resSP = new SanPhamRes();
        NSXRes resSX = new NSXRes();
        MauSacRes resMS = new MauSacRes();
        DongSpRes resDong =  new DongSpRes();
        SanPhamCTRes resCT = new SanPhamCTRes();

        if (uri.contains("/product")) {
            String x = setCC(request);
            request.setAttribute("Khach", x);
            request.setAttribute("logout", "Logout");
            ArrayList<SanPham> list = resSP.getAll();
            request.setAttribute("listSP", list);
            request.getRequestDispatcher("trang/sanpham/listSanPham.jsp").forward(request, response);
        } else if (uri.contains("/nsx")) {
            String x = setCC(request);
            request.setAttribute("Khach", x);
            request.setAttribute("logout", "Logout");
            ArrayList<NSX> list = resSX.getAll();
            request.setAttribute("listSX", list);
            request.getRequestDispatcher("trang/nsx/listNSX.jsp").forward(request, response);
        }else if (uri.contains("/colors")) {
            String x = setCC(request);
            request.setAttribute("Khach", x);
            request.setAttribute("logout", "Logout");
            ArrayList<MauSac> list = resMS.getAll();
            request.setAttribute("listMS", list);
            request.getRequestDispatcher("trang/mausac/listMauSac.jsp").forward(request, response);
        }
        else if (uri.contains("/dongSP")) {
            String x = setCC(request);
            request.setAttribute("Khach", x);
            request.setAttribute("logout", "Logout");
            ArrayList<DongSP> list = resDong.getAll();
            request.setAttribute("listDong", list);
            request.getRequestDispatcher("trang/dongsp/listDSP.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
