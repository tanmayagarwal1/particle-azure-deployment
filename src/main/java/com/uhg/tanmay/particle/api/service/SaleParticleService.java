package com.uhg.tanmay.particle.api.service;

import com.uhg.tanmay.particle.api.entity.SParticle;
import com.uhg.tanmay.particle.api.wrappers.TotalWrapper;
import com.uhg.tanmay.particle.api.wrappers.Wrapper;

import java.util.ArrayList;

public interface SaleParticleService {
    void postParticle(Wrapper wrap);
    ArrayList<Wrapper> onlySales();
    ArrayList<SParticle> getFullSales();
    ArrayList<TotalWrapper> totals();
    void updateSale(int tid, long quantity);
    void reset();
}