package respository;

import enity.ChucVu;
import org.hibernate.Session;
import org.hibernate.Transaction;
import until.HibernateUntil;

import java.util.ArrayList;

public class ChucVuRes {
    public ArrayList<ChucVu> getAll() {
        ArrayList<ChucVu> list = new ArrayList<>();
        try (Session session = HibernateUntil.getFACTORY().openSession()) {
            list = (ArrayList<ChucVu>) session.createQuery("from ChucVu ").list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public ChucVu getById(String id) {
        ChucVu result = new ChucVu();
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            result = ses.get(ChucVu.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public void add(ChucVu cv) {
        Transaction trans = null;
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            trans = ses.beginTransaction();
            ses.save(cv);
            trans.commit();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void update(ChucVu cv) {
        Transaction trans = null;
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            trans = ses.beginTransaction();
            ses.saveOrUpdate(cv);
            trans.commit();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void delete(ChucVu cv) {
        Transaction trans = null;
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            trans = ses.beginTransaction();
            ses.delete(cv);
            trans.commit();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
