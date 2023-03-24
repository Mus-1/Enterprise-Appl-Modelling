package com.taxcalculator.repositories;

import org.springframework.stereotype.Repository;
import com.taxcalculator.entities.Taxpayer;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TaxpayerRepository extends JpaRepository<Taxpayer, Integer> {
	Taxpayer findByEmailAndPassword(String email, String password);
}
