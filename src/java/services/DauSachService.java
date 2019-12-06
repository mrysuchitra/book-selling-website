/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.DauSach;
import java.util.List;
import sessionBean.DauSachDAO;

/**
 *
 * @author tien.nh173399
 */
public class DauSachService {
    private DauSachDAO database;
    public DauSachService(){
        this.database=new DauSachDAO();
    }
    
    public List<DauSach> getAll(){
        return this.database.findAll();
    }
}
