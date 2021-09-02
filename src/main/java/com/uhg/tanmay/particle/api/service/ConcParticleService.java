package com.uhg.tanmay.particle.api.service;

import com.uhg.tanmay.particle.api.entity.Particle;
import com.uhg.tanmay.particle.api.builders.ParticleBuilder;
import com.uhg.tanmay.particle.api.dao.ParticleDao;
import com.uhg.tanmay.particle.api.wrappers.GetWrapper;
import com.uhg.tanmay.particle.api.wrappers.TotalWrapper;
import com.uhg.tanmay.particle.api.wrappers.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ConcParticleService implements ParticleService {
    @Autowired
    ParticleDao dao;

    @Override
    public ArrayList<Particle> putParticles(Wrapper wrap) {
        Particle p = ParticleBuilder.builder(wrap);
        dao.save(p);
        ArrayList<Particle> particles = new ArrayList<>();
        dao.findAll().forEach(particles::add);
        return particles;

    }

    @Override
    public ArrayList<Particle> getsParticles() {
        ArrayList<Particle> particles= new ArrayList<>();
        dao.findAll().forEach(particles::add);
        return particles;
    }

    public boolean getByTid(int tid){
        ArrayList<Particle> list= new ArrayList<>();
        dao.findAll().forEach(list::add);
        for(Particle p : list){
            if (p.getTid() == tid){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Particle> getAllByTid(int tid){
        return dao.getFromTid(tid);
    }

    @Override
    public void update(int tid, double price, long quantity) {
        dao.update(tid, price, quantity);
    }

    @Override
    public ArrayList<GetWrapper> getsNecessaryParticles() {
        return dao.getOnlyNecessary();
    }

    @Override
    public void putsPrice(Wrapper wrap) {
        dao.putPrice(wrap.getTid(), wrap.getPrice(), wrap.getQuantity());
    }

    @Override
    public ArrayList<TotalWrapper> getTotals() {
        return dao.getTotal();
    }

    @Override
    public ArrayList<Particle> getAllByTidAndPrice(int tid, double price, long quantity) {
        return dao.getbyPriceAndid(tid, price, quantity);
    }

    @Override
    public void updateAdd(int tid, double price, long quantity) {
        dao.updateAdd(tid, price, quantity);
    }

    @Override
    public ArrayList<Particle> filterPrice() {
        return dao.filterByPrice();
    }

    @Override
    public ArrayList<Particle> filterQuantity() {
        return dao.filterByQuantity();
    }

    @Override
    public ArrayList<Particle> filterCharge() {
        return dao.filterByCharge();
    }

    @Override
    public void reset() {
        for(Particle p : dao.findAll()){
            dao.delete(p);
        }
    }
}