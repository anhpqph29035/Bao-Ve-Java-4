package severlet;

import enity.DongSP;
import enity.SanPham;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import respository.DongSpRes;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "DongSPServlet", value = {
        "/showAddDSP",
        "/addDSP",
        "/detailDSP",
        "/removeDSP",
        "/updateDSP"
})
public class DongSPServlet extends HttpServlet {
    DongSpRes resDSP = new DongSpRes();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/showAddDSP")) {
            request.getRequestDispatcher("trang/dongsp/addDSP.jsp").forward(request, response);
        } else if (uri.contains("removeDSP")) {
            String id= request.getParameter("id");
            DongSP dsp = resDSP.getById(id);
            resDSP.delete(dsp);
            response.sendRedirect("/dongSP");
        }else if (uri.contains("detailDSP")) {
            String id= request.getParameter("id");
            DongSP dsp = resDSP.getById(id);
            request.setAttribute("listUD", dsp);
            request.getRequestDispatcher("trang/dongsp//detailDSP.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri= request.getRequestURI();
        if(uri.contains("addDSP")){
            DongSP dsp = new DongSP();
            try {
                BeanUtils.populate(dsp,request.getParameterMap());
                resDSP.add(dsp);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/dongSP");
        } else if (uri.contains("updateDSP")) {
            DongSP dsp = new DongSP();
            try {
                BeanUtils.populate(dsp,request.getParameterMap());
                resDSP.update(dsp);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/dongSP");
        }
    }
}
