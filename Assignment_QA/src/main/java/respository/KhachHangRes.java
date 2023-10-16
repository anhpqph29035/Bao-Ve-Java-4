package respository;

import enity.KhachHang;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import until.HibernateUntil;

import java.util.ArrayList;

public class KhachHangRes {
    public ArrayList<KhachHang> getAll() {
        ArrayList<KhachHang> list = new ArrayList<>();
        try (Session session = HibernateUntil.getFACTORY().openSession()) {
            list = (ArrayList<KhachHang>) session.createQuery("from KhachHang ").list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public KhachHang checkLogin(String ma,String pass){
        KhachHang kh = new KhachHang();
        try (Session session = HibernateUntil.getFACTORY().openSession()) {
            Query qr = session.createQuery("from KhachHang where maKH =:ma and matKhauKH =:pass");
            qr.setParameter("ma",ma);
            qr.setParameter("pass",pass);
            kh = (KhachHang) qr.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return kh;
    }

    public KhachHang getById(String id) {
       KhachHang result = new KhachHang();
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            result = ses.get(KhachHang.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public void add(KhachHang kh) {
        Transaction trans = null;
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            trans = ses.beginTransaction();
            ses.save(kh);
            trans.commit();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void update(KhachHang kh) {
        Transaction trans = null;
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            trans = ses.beginTransaction();
            ses.saveOrUpdate(kh);
            trans.commit();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void delete(KhachHang kh) {
        Transaction trans = null;
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            trans = ses.beginTransaction();
            ses.delete(kh);
            trans.commit();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
