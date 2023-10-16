package respository;


import enity.NSX;
import org.hibernate.Session;
import org.hibernate.Transaction;
import until.HibernateUntil;

import java.util.ArrayList;

public class NSXRes {
    public ArrayList<NSX> getAll() {
        ArrayList<NSX> list = new ArrayList<>();
        try (Session session = HibernateUntil.getFACTORY().openSession()) {
            list = (ArrayList<NSX>) session.createQuery("from NSX ").list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public NSX getById(String id) {
        NSX result = new NSX();
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            result = ses.get(NSX.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public void add(NSX nsx) {
        Transaction trans = null;
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            trans = ses.beginTransaction();
            ses.save(nsx);
            trans.commit();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void update(NSX nsx) {
        Transaction trans = null;
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            trans = ses.beginTransaction();
            ses.saveOrUpdate(nsx);
            trans.commit();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void delete(NSX nsx) {
        Transaction trans = null;
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            trans = ses.beginTransaction();
            ses.delete(nsx);
            trans.commit();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
