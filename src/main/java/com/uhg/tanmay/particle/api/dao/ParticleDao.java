package com.uhg.tanmay.particle.api.dao;

import com.uhg.tanmay.particle.api.entity.Particle;
import com.uhg.tanmay.particle.api.wrappers.GetWrapper;
import com.uhg.tanmay.particle.api.wrappers.TotalWrapper;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.ArrayList;

public interface ParticleDao extends CrudRepository<Particle, Integer> {
    @Query(value = "SELECT p FROM Particle p WHERE p.tid = :#{#obj}")
    ArrayList<Particle> getFromTid(@Param("obj") int obj);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Particle p SET p.quantity = p.quantity - :#{#qobj} WHERE p.tid = :#{#tobj} AND p.price = :#{#pobj}")
    void update(@Param("tobj") int tobj, @Param("pobj") double pobj, @Param("qobj") long qobj);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Particle p SET p.quantity = p.quantity + :#{#qobj} WHERE p.tid = :#{#tobj} AND p.price = :#{#pobj}")
    void updateAdd(@Param("tobj") int tobj, @Param("pobj") double pobj, @Param("qobj") long qobj);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Particle p SET p.price = :#{#pobj} WHERE p.tid = :#{#tobj} AND p.quantity = :#{#qobj}")
    void putPrice(@Param("tobj") int tobj, @Param("pobj") double pobj, @Param("qobj") long qobj);

    @Query(value = "SELECT new com.uhg.tanmay.particle.api.wrappers.GetWrapper(p.tid, p.type, p.quantity, p.price) FROM Particle p")
    ArrayList<GetWrapper> getOnlyNecessary();

    @Query(value = "SELECT new com.uhg.tanmay.particle.api.wrappers.TotalWrapper(p.tid, SUM(p.quantity), SUM(p.price), AVG(p.price)) FROM Particle p GROUP BY(p.tid)")
    ArrayList<TotalWrapper> getTotal();

    @Query(value = "SELECT p from Particle p WHERE p.tid = :#{#tobj} and p.price = :#{#pobj} and p.quantity >= :#{#qobj}")
    ArrayList<Particle> getbyPriceAndid(@Param("tobj") int tid,@Param("pobj") double price,@Param("qobj") long quantity);

    @Query(value = "Select p from Particle p ORDER BY p.price DESC")
    ArrayList<Particle> filterByPrice();

    @Query(value = "Select p from Particle p ORDER BY p.quantity DESC")
    ArrayList<Particle> filterByQuantity();

    @Query(value = "Select p from Particle p ORDER BY p.charge DESC")
    ArrayList<Particle> filterByCharge();
}