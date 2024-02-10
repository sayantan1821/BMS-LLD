package com.sayantan.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theater extends BaseModel{
    @OneToMany
    private List<Screen> screens;
    @ManyToOne
    private Region region;
    private String name;
    private String address;
}
