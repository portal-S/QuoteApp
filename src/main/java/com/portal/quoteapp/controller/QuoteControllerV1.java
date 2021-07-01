package com.portal.quoteapp.controller;

import com.portal.quoteapp.model.Quote;
import com.portal.quoteapp.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/quotes")
@CrossOrigin
public class QuoteControllerV1 {

    private QuoteService service;

    @Autowired
    public QuoteControllerV1(QuoteService service) {
        this.service = service;
    }

    @GetMapping("/topByScore")
    public ResponseEntity<List<Quote>> getTopByScore(){
        List<Quote> quoteList = service.getTopByScore();
        if(quoteList.isEmpty() || quoteList == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(quoteList, HttpStatus.OK);
    }

    @GetMapping("/distinctByScore")
    public ResponseEntity<List<Quote>> getDistinctByScore(){
        List<Quote> quoteList = service.getDistinctByScore();
        if(quoteList.isEmpty() || quoteList == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(quoteList, HttpStatus.OK);
    }

    @GetMapping("/topByPostedDate")
    public ResponseEntity<Quote> getTopByPostedDate(){
        Quote quote = service.getTopByPostedDate();
        if(quote == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(quote, HttpStatus.OK);
    }

    @GetMapping("/randomElement")
    public ResponseEntity<Quote> getRandomElement(){
        Quote quote = service.getRandomElement();
        if(quote == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(quote, HttpStatus.OK);
    }

    @PutMapping("/like")
    public ResponseEntity<Quote> like(@RequestParam("id") int id){
        return new ResponseEntity<>(service.like(id), HttpStatus.OK);
    }

    @PutMapping("/dislike")
    public ResponseEntity<Quote> disLike(@RequestParam("id") int id){
        return new ResponseEntity<>(service.disLike(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quote> get(@PathVariable("id") int id){
        Quote found = service.get(id);
        if(found == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Quote> save(@RequestBody Quote quote){
        System.out.println(quote);
        if(quote == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        service.save(quote);
        return new ResponseEntity<>(quote, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Quote> update(@RequestBody Quote quote){
        if(quote == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Quote found = service.get(quote.getId());
        if(found == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.update(quote);
        return new ResponseEntity<>(quote, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Quote> delete(@PathVariable("id") int id){
        Quote found = service.get(id);
        if(found == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
