package com.portal.quoteapp.service.impl;

import com.portal.quoteapp.model.Quote;
import com.portal.quoteapp.repository.QuoteRepository;
import com.portal.quoteapp.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService {

    private QuoteRepository repository;

    @Autowired
    public QuoteServiceImpl(QuoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Quote> getTopByScore() {
        return repository.getTopByScore(PageRequest.of(0, 10));
    }

    @Override
    public List<Quote> getDistinctByScore() {
        return repository.getDistinctByScore(PageRequest.of(0, 10));
    }

    @Override
    public Quote getTopByPostedDate() {
        return repository.getTopByPostedDate(PageRequest.of(0, 1)).get(0);
    }

    @Override
    public Quote getRandomElement() {
        return repository.getRandomElement().get(0);
    }

    @Override
    public Quote like(int id) {
        Quote quote = repository.getById(id);
        quote.setScore(quote.getScore() + 1);
        repository.save(quote);
        return quote;
    }

    @Override
    public Quote disLike(int id) {
        Quote quote = repository.getById(id);
        quote.setScore(quote.getScore() - 1);
        repository.save(quote);
        return quote;
    }

    @Override
    public void save(Quote quote) {
        repository.save(quote);
    }

    @Override
    public Quote get(int id) {
        return repository.getById(id);
    }

    @Override
    public void update(Quote quote) {
        repository.save(quote);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
