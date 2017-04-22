package me.hjava.dao;
import java.util.List;

import me.hjava.entity.Konyv;
public interface IKonyvDAO {
    List<Konyv> getAllKonyv();
    Konyv getKonyvById(int k_id);
    void addKonyv(Konyv konyv);
    void updateKonyv(Konyv konyv);
    void deleteKonyv(int k_id);
    boolean konyvExists(String cim, String location);
}
 