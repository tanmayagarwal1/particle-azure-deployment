package com.uhg.tanmay.particle.api.dao;

import java.util.*;

import com.uhg.tanmay.particle.api.entity.SParticle;
import com.uhg.tanmay.particle.api.wrappers.TotalWrapper;
import com.uhg.tanmay.particle.api.wrappers.Wrapper;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface SaleParticleDao extends CrudRepository<SParticle, Integer> {
    @Query(value = "SELECT new com.uhg.tanmay.particle.api.wrappers.Wrapper(s.tid, s.price, s.quantity) FROM SParticle s" )
    ArrayList<Wrapper> getOnlySales();

    @Transactional
    @Modifying
    @Query(value = "Update SParticle s set s.quantity = s.quantity + :#{#qobj} WHERE s.tid = :#{#tobj}")
    void update(@Param("tobj") int tobj  ,@Param("qobj") long quantity);

    @Query(value = "SELECT new com.uhg.tanmay.particle.api.wrappers.TotalWrapper(s.tid, SUM(s.quantity), SUM(s.price), AVG(s.price)) FROM SParticle s GROUP BY(s.tid)")
    ArrayList<TotalWrapper> getTotals();
}
