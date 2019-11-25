package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=3)
    private String title;

    @NotNull
    @Size(min=3)
    private String description;

    @NotNull
    @Size(min=3)
    private String postedDate;

    @NotNull
    @Size(min=3)
    private String author;

    @NotNull
    @Size(min=3)
    private String phone;

    private String jobshot;

    public Job(@NotNull @Size(min = 3) String title, @NotNull @Size(min = 3) String description, @NotNull @Size(min = 3) String postedDate, @NotNull @Size(min = 3) String author, @NotNull @Size(min = 3) String phone) {
        this.title = title;
        this.description = description;
        this.postedDate = postedDate;
        this.author = author;
        this.phone = phone;
    }

    public Job() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJobshot() {
        return jobshot;
    }

    public void setJobshot(String jobshot) {
        this.jobshot = jobshot;
    }
}