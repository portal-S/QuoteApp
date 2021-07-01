package com.portal.quoteapp.service;

import com.portal.quoteapp.model.Quote;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

public interface QuoteService {
    List<Quote> getTopByScore();

    List<Quote> getDistinctByScore();

    Quote getTopByPostedDate();

    Quote getRandomElement();

    Quote like(int id);

    Quote disLike(int id);

    void save(Quote quote);

    Quote get(int id);

    void update(Quote quote);

    void delete(int id);
}
