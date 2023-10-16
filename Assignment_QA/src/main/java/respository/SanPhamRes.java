package respository;

import enity.SanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;
import until.HibernateUntil;

import java.util.ArrayList;

public class SanPhamRes {
    public ArrayList<SanPham> getAll() {
        ArrayList<SanPham> list = new ArrayList<>();
        try (Session session = HibernateUntil.getFACTORY().openSession()) {
            list = (ArrayList<SanPham>) session.createQuery("from SanPham ").list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public SanPham getById(String id) {
        SanPham result = new SanPham();
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            result = ses.get(SanPham.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public void add(SanPham sp) {
        Transaction trans = null;
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            trans = ses.beginTransaction();
            ses.save(sp);
            trans.commit();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void update(SanPham sp) {
        Transaction trans = null;
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            trans = ses.beginTransaction();
            ses.saveOrUpdate(sp);
            trans.commit();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void delete(SanPham sp) {
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
