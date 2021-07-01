package com.portal.quoteapp.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "quotes")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Quote implements Serializable {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "text")
    private String text;

    @Column(name = "score")
    private int score;

    @Column(name = "posted_name")
    private String postedName;

    @Column(name = "posted_date", insertable = false)
    private Date postedDate;

    public Quote() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPostedName() {
        return postedName;
    }

    public void setPostedName(String postedName) {
        this.postedName = postedName;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", score=" + score +
                ", postedName='" + postedName + '\'' +
                ", postedDate=" + postedDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote = (Quote) o;
        return id == quote.id && score == quote.score && Objects.equals(text, quote.text) && Objects.equals(postedName, quote.postedName) && Objects.equals(postedDate, quote.postedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, score, postedName, postedDate);
    }
}
