package respository;

import enity.CuaHang;
import org.hibernate.Session;
import org.hibernate.Transaction;
import until.HibernateUntil;

import java.util.ArrayList;

public class CuaHangRes {
    public ArrayList<CuaHang> getAll() {
        ArrayList<CuaHang> list = new ArrayList<>();
        try (Session session = HibernateUntil.getFACTORY().openSession()) {
            list = (ArrayList<CuaHang>) session.createQuery("from CuaHang ").list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public CuaHang getById(String id) {
        CuaHang result = new CuaHang();
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            result = ses.get(CuaHang.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public void add(CuaHang ch) {
        Transaction trans = null;
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            trans = ses.beginTransaction();
            ses.save(ch);
            trans.commit();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void update(CuaHang ch) {
        Transaction trans = null;
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            trans = ses.beginTransaction();
            ses.saveOrUpdate(ch);
            trans.commit();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void delete(CuaHang ch) {
        Transaction trans = null;
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            trans = ses.beginTransaction();
            ses.delete(ch);
            trans.commit();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
