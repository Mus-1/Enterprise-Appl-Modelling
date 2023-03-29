package com.taxcalculator.repositories;

import org.springframework.stereotype.Repository;

import com.taxcalculator.entities.Taxform;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TaxformRepository extends JpaRepository<Taxform, Integer> {

}
