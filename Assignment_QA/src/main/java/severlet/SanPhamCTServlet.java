package severlet;

import enity.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import respository.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

@WebServlet(name = "SanPhamCTServlet", value = {
        "/showAddSPCT",
        "/addSPCT",
        "/detailSPCT",
        "/removeSPCT",
        "/updateSPCT"
})
public class SanPhamCTServlet extends HttpServlet {
    SanPhamCTRes resCT = new SanPhamCTRes();
    SanPhamRes resSP = new SanPhamRes();
    NSXRes resNSX = new NSXRes();
    MauSacRes resMS = new MauSacRes();
    DongSpRes resDong = new DongSpRes();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/showAddSPCT")) {
            String x = setCC(request);
            request.setAttribute("Khach", x);
            request.setAttribute("logout", "Logout");
            request.setAttribute("listSP", resSP.getAll());
            request.setAttribute("listNSX", resNSX.getAll());
            request.setAttribute("listMS", resMS.getAll());
            request.setAttribute("listDong", resDong.getAll());
            request.getRequestDispatcher("trang/sanphamct/addCTSP.jsp").forward(request, response);
        } else if (uri.contains("/removeSPCT")) {
            String id= request.getParameter("id");
            SanPhamCT ct = resCT.getById(id);
            resCT.delete(ct);
            response.sendRedirect("/sanphamct");
        }else if (uri.contains("detailSPCT")) {
            String x = setCC(request);
            request.setAttribute("Khach", x);
            request.setAttribute("logout", "Logout");
            String id= request.getParameter("id");
            SanPhamCT ct = resCT.getById(id);
            request.setAttribute("listUD", ct);
            request.setAttribute("listSP", resSP.getAll());
            request.setAttribute("listNSX", resNSX.getAll());
            request.setAttribute("listMS", resMS.getAll());
            request.setAttribute("listDong", resDong.getAll());
            request.getRequestDispatcher("trang/sanphamct/detailCTSP.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri= request.getRequestURI();
        String id1 = request.getParameter("sanPham.idSP");
        String id2 = request.getParameter("nsxCTSP.idNSX");
        String id3 = request.getParameter("mauSac.idMS");
        String id4 = request.getParameter("dongCTSP.idDSP");
        if(uri.contains("addSPCT")){
            SanPhamCT ct = new SanPhamCT();
            try {
                SanPham sp = new SanPham();
                NSX nsx = new NSX();
                MauSac ms = new MauSac();
                DongSP dsp = new DongSP();
                sp.setIdSP(id1);
                nsx.setIdNSX(id2);
                ms.setIdMS(id3);
                dsp.setIdDSP(id4);
                BeanUtils.populate(ct,request.getParameterMap());
                ct.setSanPham(sp);
                ct.setMauSac(ms);
                ct.setNsxCTSP(nsx);
                ct.setDongCTSP(dsp);
                resCT.add(ct);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/sanphamct");
        } else if (uri.contains("updateSPCT")) {
            try {
                SanPhamCT ct = new SanPhamCT();
                SanPham sp = new SanPham();
                NSX nsx = new NSX();
                MauSac ms = new MauSac();
                DongSP dsp = new DongSP();
                sp.setIdSP(id1);
                nsx.setIdNSX(id2);
                ms.setIdMS(id3);
                dsp.setIdDSP(id4);
                BeanUtils.populate(ct,request.getParameterMap());
                ct.setSanPham(sp);
                ct.setMauSac(ms);
                ct.setNsxCTSP(nsx);
                ct.setDongCTSP(dsp);
                resCT.update(ct);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/sanphamct");
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
