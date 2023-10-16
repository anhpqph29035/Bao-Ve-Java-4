package respository;

import enity.DongSP;
import org.hibernate.Session;
import org.hibernate.Transaction;
import until.HibernateUntil;

import java.util.ArrayList;

public class DongSpRes {
    public ArrayList<DongSP> getAll() {
        ArrayList<DongSP> list = new ArrayList<>();
        try (Session session = HibernateUntil.getFACTORY().openSession()) {
            list = (ArrayList<DongSP>) session.createQuery("from DongSP ").list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public DongSP getById(String id) {
        DongSP result = new DongSP();
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            result = ses.get(DongSP.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public void add(DongSP sp) {
        Transaction trans = null;
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            trans = ses.beginTransaction();
            ses.save(sp);
            trans.commit();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void update(DongSP sp) {
        Transaction trans = null;
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            trans = ses.beginTransaction();
            ses.saveOrUpdate(sp);
            trans.commit();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void delete(DongSP sp) {
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
