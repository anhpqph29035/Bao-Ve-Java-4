package respository;

import enity.HoaDonChiTiet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import until.HibernateUntil;

import java.util.ArrayList;
public class HoaDonCTRes {
    public void add(HoaDonChiTiet hoaDonChiTiet) {
        Transaction transaction = null;
        try (Session session = HibernateUntil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(hoaDonChiTiet);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<HoaDonChiTiet> getHDCTbyID(String id){
        ArrayList<HoaDonChiTiet> listSP=new ArrayList<>();
        try (Session session = HibernateUntil.getFACTORY().openSession()) {
            Query query= session.createQuery("from HoaDonChiTiet where hoaDon.id=:id");
            query.setParameter("id",id);
            listSP= (ArrayList<HoaDonChiTiet>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listSP;
    }
}
