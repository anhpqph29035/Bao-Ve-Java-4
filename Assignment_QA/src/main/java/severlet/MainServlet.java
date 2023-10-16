package severlet;

import enity.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import respository.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "MainServlet", value = {
        "/home",
        "/sanphamct",
        "/nhanvien",
        "/timKiem",
        "/showCart",
        "/showHoaDon",
        "/showCTHoaDon",
        "/locHoaDon",
        "/detail"
})
public class MainServlet extends HttpServlet {
    SanPhamCTRes resCT = new SanPhamCTRes();
    NhanVienRes resNV = new NhanVienRes();
    SanPhamRes resSP = new SanPhamRes();
    NSXRes resNSX = new NSXRes();
    MauSacRes resMS = new MauSacRes();
    DongSpRes resDong = new DongSpRes();
    GioHangRes resGH = new GioHangRes();
    GioHangCTRes resGHCT = new GioHangCTRes();
    HoaDonRes hdr = new HoaDonRes();
    HoaDonCTRes hdcr = new HoaDonCTRes();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/home")) {
            String x = setCC(request);
            request.setAttribute("Khach", x);
            request.setAttribute("logout", "Logout");
            ArrayList<SanPhamCT> list = resCT.getAll();
            request.setAttribute("listSPCT", list);
            request.getRequestDispatcher("web/home.jsp").forward(request, response);
        } else if (uri.contains("/sanphamct")) {
            String x = setCC(request);
            request.setAttribute("Khach", x);
            request.setAttribute("logout", "Logout");
            String value = "";
            Cookie ck[] = request.getCookies();
            if (ck != null) {
                for (Cookie cookie : ck) {
                    if (cookie.getName().equals("idKH")) {
                        value = cookie.getValue();
                    }
                }
            }
            if (value == "") {
                response.sendRedirect("/login");
            } else {
                ArrayList<SanPhamCT> list = resCT.getAll();
                request.setAttribute("listSPCT", list);
                request.getRequestDispatcher("trang/sanphamct/listCTSP.jsp").forward(request, response);
            }
        } else if (uri.contains("/nhanvien")) {
            String value = "";
            Cookie ck[] = request.getCookies();
            if (ck != null) {
                for (Cookie cookie : ck) {
                    if (cookie.getName().equals("idKH")) {
                        value = cookie.getValue();
                    }
                }
            }
            if (value == "") {
                response.sendRedirect("/login");
            } else {
                request.setAttribute("listNV", resNV.getAll());
                request.getRequestDispatcher("trang/nhanvien/listNV.jsp").forward(request, response);
            }
        } else if (uri.contains("/detail")) {
            String x = setCC(request);
            request.setAttribute("Khach", x);
            request.setAttribute("logout", "Logout");
            String id = request.getParameter("id");
            SanPhamCT ct = resCT.getById(id);
            request.setAttribute("listDT", ct);
            request.setAttribute("listSP", resSP.getAll());
            request.setAttribute("listNSX", resNSX.getAll());
            request.setAttribute("listMS", resMS.getAll());
            request.setAttribute("listDong", resDong.getAll());
            request.getRequestDispatcher("web/detail.jsp").forward(request, response);
        } else if (uri.contains("/timKiem")) {
            request.setCharacterEncoding("UTF-8");
            String x = setCC(request);
            request.setAttribute("Khach", x);
            request.setAttribute("logout", "Logout");
            String ma = request.getParameter("maTim");
            ArrayList<SanPhamCT> list = resCT.getByName(ma);
            if (list.isEmpty()) {
                String koTim = "Không tồn tại sản phẩm";
                request.setAttribute("koTim", koTim);
                request.setAttribute("listSPCT", resCT.getAll());
                request.getRequestDispatcher("web/home.jsp").forward(request, response);
            } else {
                request.setAttribute("listSPCT", list);
                request.getRequestDispatcher("web/home.jsp").forward(request, response);
            }
        } else if (uri.contains("/showCart")) {
            String x = setCC(request);
            request.setAttribute("Khach", x);
            request.setAttribute("logout", "Logout");
            String value = "";
            Cookie ck[] = request.getCookies();
            if (ck != null) {
                for (Cookie cookie : ck) {
                    if (cookie.getName().equals("idKH")) {
                        value = cookie.getValue();
                    }
                }
            }
            if (value == "") {
                response.sendRedirect("/login");
            } else {
                GioHang gh = resGH.getGHbyID(value);
                if (gh != null) {
                    String idgh = gh.getId();
                    double tong = 0;
                    ArrayList<GioHangChiTiet> list = resGHCT.getGHCTbyID(idgh);
                    for (GioHangChiTiet a : list) {
                        tong += a.getDonGia().doubleValue();
                    }
                    request.setAttribute("tongtien", tong);
                    request.setAttribute("listGH", list);
                }
                request.getRequestDispatcher("web/giohang.jsp").forward(request, response);
            }

        } else if (uri.contains("/showHoaDon")) {
            String x = setCC(request);
            request.setAttribute("Khach", x);
            request.setAttribute("logout", "Logout");
            String value = "";
            Cookie ck[] = request.getCookies();
            if (ck != null) {
                for (Cookie cookie : ck) {
                    if (cookie.getName().equals("idKH")) {
                        value = cookie.getValue();
                    }
                }
            }
            if (value == "") {
                response.sendRedirect("/login");
            } else {
                ArrayList<HoaDon> list = hdr.getHDbyKhachHang(value);
                request.setAttribute("listHD", list);
                    request.getRequestDispatcher("web/hoadon.jsp").forward(request, response);

            }

        } else if (uri.contains("/showCTHoaDon")) {
            String x = setCC(request);
            request.setAttribute("Khach", x);
            request.setAttribute("logout", "Logout");
            String id = request.getParameter("id");
            ArrayList<HoaDonChiTiet> list = hdcr.getHDCTbyID(id);
            if (!list.isEmpty()) {
                request.setAttribute("listHDCT", list);
                request.getRequestDispatcher("web/cthoadon.jsp").forward(request, response);
            }
        }else  if (uri.contains("/locHoaDon")) {
            String x = setCC(request);
            request.setAttribute("Khach", x);
            request.setAttribute("logout", "Logout");
            String value = "";
            Cookie ck[] = request.getCookies();
            if (ck != null) {
                for (Cookie cookie : ck) {
                    if (cookie.getName().equals("idKH")) {
                        value = cookie.getValue();
                    }
                }
            }
            String ngayBD = request.getParameter("ngayBD");
            String ngayKT = request.getParameter("ngayKT");
            if (ngayBD.isEmpty() && ngayKT.isEmpty()) {
                ArrayList<HoaDon> list = hdr.getHDbyKhachHang(value);
                if (!list.isEmpty()) {
                    request.setAttribute("listHD", list);
                    request.getRequestDispatcher("web/hoadon.jsp").forward(request, response);
                }
            }else{
                if (ngayBD.isEmpty()) {
                    ngayBD = "1900-01-01";
                } else if (ngayKT.isEmpty()) {
                    ngayKT = "2900-01-01";
                }
                request.setAttribute("listHD", hdr.getHDbyKhachHangByTime(value, ngayBD, ngayKT));
                request.getRequestDispatcher("web/hoadon.jsp").forward(request, response);
            }
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
