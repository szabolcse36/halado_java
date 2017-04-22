package me.hjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.hjava.dao.IKonyvDAO;
import me.hjava.entity.Konyv;
@Service
public class KonyvService implements IKonyvService {
	@Autowired
	private IKonyvDAO konyvDAO;
	@Override
	public Konyv getKonyvById(int k_id) {
		Konyv obj = konyvDAO.getKonyvById(k_id);
		return obj;
	}	
	@Override
	public List<Konyv> getAllKonyv(){
		return konyvDAO.getAllKonyv();
	}
	@Override
	public synchronized boolean createKonyv(Konyv konyv){
       if (konyvDAO.konyvExists(konyv.getCim(), konyv.getIro())) {
    	   return false;
       } else {
    	   konyvDAO.addKonyv(konyv);
    	   return true;
       }
	}
	@Override
	public void updateKonyv(Konyv konyv) {
		konyvDAO.updateKonyv(konyv);
	}
	@Override
	public void deleteKonyv(int k_id) {
		konyvDAO.deleteKonyv(k_id);
	}
}
