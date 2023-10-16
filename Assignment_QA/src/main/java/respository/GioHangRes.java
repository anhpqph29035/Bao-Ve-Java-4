package respository;

import enity.GioHang;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import until.HibernateUntil;

import java.util.ArrayList;

public class GioHangRes {
    public ArrayList<GioHang> getALlGH() {
        ArrayList<GioHang> listSP = new ArrayList<>();
        try (Session session = HibernateUntil.getFACTORY().openSession()) {
            Query query = session.createQuery("from GioHang ");
            listSP = (ArrayList<GioHang>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }
    public void add(GioHang gh) {
        Transaction transaction = null;
        try (Session session = HibernateUntil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(gh);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void Update(GioHang gh) {
        Transaction transaction = null;
        try (Session session = HibernateUntil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(gh);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public GioHang getGHbyID(String id) {
        GioHang gioHang = null;
        try (Session session = HibernateUntil.getFACTORY().openSession()) {
            Query query = session.createQuery("from GioHang g where g.khachHang.id=: id and g.tinhTrang=0");
            query.setParameter("id", id);
            gioHang = (GioHang) query.getSingleResult();
            return gioHang;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
