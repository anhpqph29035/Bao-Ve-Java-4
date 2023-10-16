package respository;

import enity.SanPhamCT;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import until.HibernateUntil;

import java.util.ArrayList;
import java.util.List;

public class SanPhamCTRes {
    public ArrayList<SanPhamCT> getAll() {
        ArrayList<SanPhamCT> list = new ArrayList<>();
        try (Session session = HibernateUntil.getFACTORY().openSession()) {
            list = (ArrayList<SanPhamCT>) session.createQuery("from SanPhamCT ").list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public ArrayList<SanPhamCT> getByName(String name) {
        try (Session session = HibernateUntil.getFACTORY().openSession()) {
            if (name == null) {
                name = "%";
            } else {
                name = "%" + name.replaceAll(" ","%") + "%";
            }
            String hql = " FROM SanPhamCT E WHERE REPLACE(concat(E.sanPham.tenSP,E.mauSac.tenMS,E.nsxCTSP.tenNSX,E.dongCTSP.tenDSP),' ','')like : name";
            Query query = session.createQuery(hql);
            query.setParameter("name", name);
            ArrayList<SanPhamCT> reults = (ArrayList<SanPhamCT>) query.list();
            return reults;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public SanPhamCT getById(String id) {
        SanPhamCT result = new SanPhamCT();
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            result = ses.get(SanPhamCT.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public void add(SanPhamCT sp) {
        Transaction trans = null;
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            trans = ses.beginTransaction();
            ses.save(sp);
            trans.commit();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void update(SanPhamCT sp) {
        Transaction trans = null;
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            trans = ses.beginTransaction();
            ses.saveOrUpdate(sp);
            trans.commit();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void delete(SanPhamCT sp) {
        Transaction trans = null;
        try (Session ses = HibernateUntil.getFACTORY().openSession()) {
            trans = ses.beginTransaction();
            ses.delete(sp);
            trans.commit();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<SanPhamCT> pagingCTSP(int pageNumber, int pageSize){
        try (Session session = HibernateUntil.getFACTORY().openSession()) {
            Query<SanPhamCT> query = session.createQuery("from  SanPhamCT order by idCTSP desc ");

            int firstNumber = (pageNumber -1)*pageSize;
            query.setFirstResult(firstNumber);
            query.setMaxResults(pageSize);
            List<SanPhamCT>listct=  query.list();
            return listct;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("FAILED");
            return null;
        }
    }
}
