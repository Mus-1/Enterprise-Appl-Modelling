package com.taxcalculator.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.taxcalculator.entities.TaxBracket;

@Repository
public interface TaxBracketRepository extends JpaRepository<TaxBracket, Integer> {
	@Query("SELECT tb FROM TaxBracket tb "
			+ "WHERE tb.territory = :province "
			+ "AND tb.year = :year "
			+ "AND (:total_income >= tb.start_range "
			+ "OR :total_income BETWEEN tb.start_range+1 AND tb.end_range)")
	List<TaxBracket> getProvincialTaxBracketByTotalIncome(@Param("total_income") double total_income,
			@Param("province") String province, @Param("year") String year);

	@Query("SELECT tb FROM TaxBracket tb "
			+ "WHERE tb.territory = 'Federal' "
			+ "AND tb.year = :year "
			+ "AND (:total_income >= tb.start_range "
			+ "OR :total_income BETWEEN tb.start_range+1 AND tb.end_range)")
	List<TaxBracket> getFederalTaxeBracketByTotalIncome(@Param("total_income") double total_income,
			@Param("year") String year);
}