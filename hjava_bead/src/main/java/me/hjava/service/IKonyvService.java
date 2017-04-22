package me.hjava.service;

import java.util.List;

import me.hjava.entity.Konyv;

public interface IKonyvService {
     List<Konyv> getAllKonyv();
     Konyv getKonyvById(int k_id);
     boolean createKonyv(Konyv konyv);
     void updateKonyv(Konyv konyv);
     void deleteKonyv(int k_id);
}
