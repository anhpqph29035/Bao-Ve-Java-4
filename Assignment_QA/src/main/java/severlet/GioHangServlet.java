package severlet;

import enity.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import respository.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "GioHangServlet", value = {
        "/addgiohang",
        "/suaGioHang",
        "/xoaGioHang",
        "/thanhToan"
})
public class GioHangServlet extends HttpServlet {
    KhachHangRes resKH = new KhachHangRes();
    GioHangRes resGH = new GioHangRes();
    SanPhamCTRes resCT = new SanPhamCTRes();
    GioHangCTRes resGHCT = new GioHangCTRes();
    HoaDonRes hdR = new HoaDonRes();
    HoaDonCTRes hdcRes = new HoaDonCTRes();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/xoaGioHang")) {

            String idXGH = request.getParameter("idXGH");
            String idXSP = request.getParameter("idXSP");
            GioHangChiTiet ct = resGHCT.capNhatTonTai(idXGH, idXSP);
            resGHCT.delete(ct);
            setCC(request);
            response.sendRedirect("/showCart");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/addgiohang")) {
            String value = "";
            Cookie ck[] = request.getCookies();
            if (ck != null) {
                for (Cookie cookie : ck) {
                    if (cookie.getName().equals("idKH")) {
                        value = cookie.getValue();
                    }
                }
            }
            if(value==""){
                response.sendRedirect("/login");
            }else{
                GioHang gioHang = new GioHang();
                GioHang gh = resGH.getGHbyID(value);

                int soLuong = Integer.parseInt(request.getParameter("soLuong"));
                if (gh == null) {
                    gioHang.setKhachHang(resKH.getById(value));
                    gioHang.setMa("GH" + (resGH.getALlGH().size() + 1));
                    gioHang.setNgayTao(new Date());
                    gioHang.setTinhTrang(0);
                    resGH.add(gioHang);
                    response.sendRedirect("/showCart");
                } else {
                    String idSP = request.getParameter("idSP");
                    String idGH = gh.getId();
                    if (!locGH(idGH, idSP)) {
                        SanPhamCT ct = resCT.getById(idSP);
                        double gia = soLuong * ct.getGiaBan().doubleValue();
                        GioHangChiTiet ghtct = new GioHangChiTiet();
                        ghtct.setGioHang(gh);
                        ghtct.setChiTietSP(ct);
                        ghtct.setSoLuong(soLuong);
                        ghtct.setDonGia(BigDecimal.valueOf(gia));
                        resGHCT.add(ghtct);
                    } else {
                        SanPhamCT ct = resCT.getById(idSP);
                        GioHangChiTiet ghtct = resGHCT.capNhatTonTai(idGH, idSP);
                        int soLuongGH = ghtct.getSoLuong();
                        double giaCN = soLuongGH * ct.getGiaBan().doubleValue();
                        resGHCT.updateGHTT(soLuong, giaCN, idGH, idSP);
                    }
                    String x = setCC(request);
                    request.setAttribute("Khach", x);
                    request.setAttribute("logout", "Logout");
                    response.sendRedirect("/showCart");
                }
            }

        } else if (uri.contains("/suaGioHang")) {
            String idGH = request.getParameter("idGH");
            String idSP = request.getParameter("idSP");
            int sl = Integer.parseInt(request.getParameter("soLuong"));
            if (sl > 0) {
                SanPhamCT ct = resCT.getById(idSP);
                GioHangChiTiet gioHangChiTiet = resGHCT.capNhatTonTai(idGH, idSP);
                double giaSau = sl * ct.getGiaBan().doubleValue();
                gioHangChiTiet.setSoLuong(sl);
                gioHangChiTiet.setDonGia(BigDecimal.valueOf(giaSau));
                resGHCT.updateGH(gioHangChiTiet);
                setCC(request);
                request.setAttribute("listGH", resGHCT.getGHCTbyID(idGH));
                response.sendRedirect("/showCart");
            } else {
                SanPhamCT ct = resCT.getById(idSP);
                GioHangChiTiet gioHangChiTiet = resGHCT.capNhatTonTai(idGH, idSP);
                double giaSau = sl * ct.getGiaBan().doubleValue();
                gioHangChiTiet.setSoLuong(sl);
                gioHangChiTiet.setDonGia(BigDecimal.valueOf(giaSau));
                resGHCT.delete(gioHangChiTiet);
                setCC(request);
                request.setAttribute("listGH", resGHCT.getGHCTbyID(idGH));
                response.sendRedirect("/showCart");
            }
        } else if (uri.contains("/thanhToan")) {
            String ten = request.getParameter("tenNhan");
            String dc = request.getParameter("dcNhan");
            String sdt = request.getParameter("sdtNhan");
            String value = "";
            Cookie ck[] = request.getCookies();
            if (ck != null) {
                for (Cookie cookie : ck) {
                    if (cookie.getName().equals("idKH")) {
                        value = cookie.getValue();
                    }
                }
            }
            if (resGH.getGHbyID(value) != null) {
                GioHang gioHang = resGH.getGHbyID(value);
                HoaDon hoaDon = new HoaDon();
                String idgh = gioHang.getId();
                hoaDon.setMa("HD" + (hdR.getALlHD().size() + 1));
                KhachHang khachHang = resKH.getById(value);
                hoaDon.setKhachHang(khachHang);
                hoaDon.setNgayTao(new Date());
                hoaDon.setNgayThanhToan(new Date());
                hoaDon.setTinhTrang(1);
                hoaDon.setTenNguoiNhan(ten);
                hoaDon.setDiaChi(dc);
                hoaDon.setSdt(sdt);
                hdR.add(hoaDon);
                String idHD = hoaDon.getId();
                ArrayList<GioHangChiTiet> listGHCT = resGHCT.getGHCTbyID(idgh);
                for (GioHangChiTiet x : listGHCT) {
                    HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
                    HoaDon hd = hdR.getbyID(idHD);
                    System.out.println(hd.toString());
                    hoaDonChiTiet.setHoaDon(hd);
                    hoaDonChiTiet.setChiTietSP(x.getChiTietSP());
                    hoaDonChiTiet.setSoLuong(x.getSoLuong());
                    hoaDonChiTiet.setDonGia(x.getDonGia());
                    hdcRes.add(hoaDonChiTiet);
                }
                Date date = new Date();
                gioHang.setNgayThanhToan(date);
                gioHang.setSdt(sdt);
                gioHang.setDiaChi(dc);
                gioHang.setTenNguoiNhan(ten);
                gioHang.setTinhTrang(1);
                resGH.Update(gioHang);
                setCC(request);
                response.sendRedirect("/showHoaDon");
            }else{
                response.sendRedirect("/showCart");
            }
        }
    }

    public boolean locGH(String id, String ids) {
        ArrayList<GioHangChiTiet> list = resGHCT.getGHCTbyID(id);
        for (GioHangChiTiet x : list) {
            if (x.getChiTietSP().getIdCTSP().equalsIgnoreCase(ids)) {
                return true;
            }
        }
        return false;
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
