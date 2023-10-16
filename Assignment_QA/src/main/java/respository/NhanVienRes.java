package respository;

import enity.NhanVien;
import org.hibernate.Session;
import org.hibernate.Transaction;
import until.HibernateUntil;

import java.util.ArrayList;

public class NhanVienRes {
    public ArrayList<NhanVien> getAll() {
        ArrayList<NhanVien> list = new ArrayList<>();
        try (Session session = HibernateUntil.getFACTORY().openSession()) {
            list = (ArrayList<NhanVien>) session.createQuery("from NhanVien ").list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public NhanVien getById(String id) {
        NhanVien result = new NhanVien();
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            result = ses.get(NhanVien.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public void add(NhanVien sp) {
        Transaction trans = null;
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            trans = ses.beginTransaction();
            ses.save(sp);
            trans.commit();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void update(NhanVien sp) {
        Transaction trans = null;
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            trans = ses.beginTransaction();
            ses.saveOrUpdate(sp);
            trans.commit();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void delete(NhanVien sp) {
        Transaction trans = null;
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            trans = ses.beginTransaction();
            ses.delete(sp);
            trans.commit();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
