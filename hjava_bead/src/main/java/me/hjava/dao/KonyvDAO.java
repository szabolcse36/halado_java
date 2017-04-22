package me.hjava.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import me.hjava.entity.Konyv;
@Transactional
@Repository
public class KonyvDAO implements IKonyvDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Konyv getKonyvById(int k_id) {
		return entityManager.find(Konyv.class, k_id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Konyv> getAllKonyv() {
		String hql = "FROM Konyv as konyvcl ORDER BY konyvcl.k_id";
		return (List<Konyv>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addKonyv(Konyv konyv) {
		entityManager.persist(konyv);
	}
	@Override
	public void updateKonyv(Konyv konyv) {
		Konyv konyvcl = getKonyvById(konyv.getK_id());
		konyvcl.setCim(konyv.getCim());
		konyvcl.setIro(konyv.getIro());
		entityManager.flush();
	}
	@Override
	public void deleteKonyv(int k_id) {
		entityManager.remove(getKonyvById(k_id));
	}
	@Override
	public boolean konyvExists(String cim, String iro) {
		String hql = "FROM Konyv as konyvcl WHERE konyvcl.cim = ? and konyvcl.iro = ?";
		int count = entityManager.createQuery(hql).setParameter(1, cim)
		              .setParameter(2, iro).getResultList().size();
		return count > 0 ? true : false;
	}
}
