package com.example.examprep15oct.model.entity;

import com.example.examprep15oct.model.entity.enums.CategoryNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private CategoryNameEnum name;

    @Column(nullable = false)
    private Integer neededTime;

    public Category() {
    }

    public CategoryNameEnum getName() {
        return name;
    }

    public Category setName(CategoryNameEnum name) {
        this.name = name;
        return this;
    }

    public Integer getNeededTime() {
        return neededTime;
    }

    public Category setNeededTime(Integer neededTime) {
        this.neededTime = neededTime;
        return this;
    }
}
