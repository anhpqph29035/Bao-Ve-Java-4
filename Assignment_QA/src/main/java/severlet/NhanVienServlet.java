package severlet;

import enity.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import respository.ChucVuRes;
import respository.CuaHangRes;
import respository.NhanVienRes;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "NhanVienServlet", value = {
        "/showAddNV",
        "/addNV",
        "/detailNV",
        "/removeNV",
        "/updateNV"
})
public class NhanVienServlet extends HttpServlet {
    NhanVienRes resNV = new NhanVienRes();
    CuaHangRes resCH = new CuaHangRes();
    ChucVuRes resCV = new ChucVuRes();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/showAddNV")) {
            request.setAttribute("listCH", resCH.getAll());
            request.setAttribute("listCV", resCV.getAll());
            request.getRequestDispatcher("trang/nhanvien/addNV.jsp").forward(request, response);
        } else if (uri.contains("/removeNV")) {
            String id = request.getParameter("id");
            NhanVien nv = resNV.getById(id);
            resNV.delete(nv);
            response.sendRedirect("/nhanvien");
        } else if (uri.contains("detailNV")) {
            String id = request.getParameter("id");
            NhanVien nv = resNV.getById(id);
            request.setAttribute("listUD", nv);
            request.setAttribute("listCH", resCH.getAll());
            request.setAttribute("listCV", resCV.getAll());
            request.getRequestDispatcher("trang/nhanvien/detailNV.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String id1 = request.getParameter("cuaHang.idCH");
        String id2 = request.getParameter("chucVu.idCV");
        if (uri.contains("addNV")) {
            NhanVien nv = new NhanVien();
            try {
                CuaHang ch = new CuaHang();
                ChucVu cv = new ChucVu();
                ch.setIdCH(id1);
                cv.setIdCV(id2);
                BeanUtils.populate(nv, request.getParameterMap());
                nv.setChucVu(cv);
                nv.setCuaHang(ch);
                resNV.add(nv);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/nhanvien");
        } else if (uri.contains("updateNV")) {
            try {
                NhanVien nv = new NhanVien();
                CuaHang ch = new CuaHang();
                ChucVu cv = new ChucVu();
                ch.setIdCH(id1);
                cv.setIdCV(id2);
                BeanUtils.populate(nv, request.getParameterMap());
                nv.setChucVu(cv);
                nv.setCuaHang(ch);
                resNV.update(nv);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/nhanvien");
        }
    }
}
