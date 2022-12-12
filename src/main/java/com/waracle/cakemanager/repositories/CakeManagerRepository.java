package com.waracle.cakemanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.waracle.cakemanager.beans.Cake;

@Repository
public interface CakeManagerRepository extends JpaRepository<Cake, Integer>{

}
