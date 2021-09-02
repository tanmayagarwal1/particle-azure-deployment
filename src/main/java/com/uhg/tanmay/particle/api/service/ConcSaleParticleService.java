package com.uhg.tanmay.particle.api.service;

import com.uhg.tanmay.particle.api.entity.SParticle;
import com.uhg.tanmay.particle.api.builders.SaleBuilder;
import com.uhg.tanmay.particle.api.dao.SaleParticleDao;
import com.uhg.tanmay.particle.api.wrappers.TotalWrapper;
import com.uhg.tanmay.particle.api.wrappers.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Primary
public class ConcSaleParticleService implements SaleParticleService {

    @Autowired
    SaleParticleDao dao ;

    @Override
    public void postParticle(Wrapper wrap) {
        SParticle sp = SaleBuilder.builder(wrap);
        dao.save(sp);
    }

    @Override
    public ArrayList<Wrapper> onlySales() {
        return dao.getOnlySales();
    }

    @Override
    public ArrayList<SParticle> getFullSales() {
        ArrayList<SParticle> list = new ArrayList<>();
        dao.findAll().forEach(list::add);
        return list;
    }

    @Override
    public ArrayList<TotalWrapper> totals() {
        return dao.getTotals();
    }

    @Override
    public void updateSale(int tid, long quantity) {
        dao.update(tid, quantity);
    }

    @Override
    public void reset() {
        for(SParticle p : dao.findAll()){
            dao.delete(p);
        }
    }
}

