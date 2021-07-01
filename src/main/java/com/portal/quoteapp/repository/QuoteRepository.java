package com.portal.quoteapp.repository;

import com.portal.quoteapp.model.Quote;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Integer> {

    @Query("from Quote order by score desc")
    List<Quote> getTopByScore(Pageable pageable);

    @Query("from Quote order by score asc")
    List<Quote> getDistinctByScore(Pageable pageable);

    @Query("from Quote order by postedDate desc")
    List<Quote> getTopByPostedDate(Pageable pageable);

    @Query("from Quote order by function('RAND')")
    List<Quote> getRandomElement();
}
