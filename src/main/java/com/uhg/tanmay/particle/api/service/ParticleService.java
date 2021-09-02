package com.uhg.tanmay.particle.api.service;

import com.uhg.tanmay.particle.api.entity.Particle;
import com.uhg.tanmay.particle.api.wrappers.GetWrapper;
import com.uhg.tanmay.particle.api.wrappers.TotalWrapper;
import com.uhg.tanmay.particle.api.wrappers.Wrapper;

import java.util.ArrayList;

public interface ParticleService {
    ArrayList<Particle> putParticles(Wrapper wrap) ;
    ArrayList<Particle> getsParticles();
    boolean getByTid(int tid);
    ArrayList<Particle> getAllByTid(int tid);
    void update(int tid, double price, long quantity);
    ArrayList<GetWrapper> getsNecessaryParticles();
    void putsPrice(Wrapper wrap);
    ArrayList<TotalWrapper> getTotals();
    ArrayList<Particle> getAllByTidAndPrice(int tid, double price, long quantity);
    void updateAdd(int tid, double price, long quantity);
    ArrayList<Particle> filterPrice();
    ArrayList<Particle> filterQuantity();
    ArrayList<Particle> filterCharge();
    void reset();
}
