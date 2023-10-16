package respository;


import enity.MauSac;
import org.hibernate.Session;
import org.hibernate.Transaction;
import until.HibernateUntil;

import java.util.ArrayList;

public class MauSacRes {
    public ArrayList<MauSac> getAll() {
        ArrayList<MauSac> list = new ArrayList<>();
        try (Session session = HibernateUntil.getFACTORY().openSession()) {
            list = (ArrayList<MauSac>) session.createQuery("from MauSac ").list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public MauSac getById(String id) {
        MauSac result = new MauSac();
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            result = ses.get(MauSac.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public void add(MauSac ms) {
        Transaction trans = null;
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            trans = ses.beginTransaction();
            ses.save(ms);
            trans.commit();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void update(MauSac ms) {
        Transaction trans = null;
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            trans = ses.beginTransaction();
            ses.saveOrUpdate(ms);
            trans.commit();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void delete(MauSac ms) {
        Transaction trans = null;
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            trans = ses.beginTransaction();
            ses.delete(ms);
            trans.commit();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
