package com.esperluette.nice.domain;

import javax.persistence.*;

@Entity
@Table(name = "preferences")
public class Preferences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @OneToOne
    User user;

    @Column(name = "museum")
    boolean museum;

    @Column(name = "sport")
    boolean sport;

    @Column(name = "technology")
    boolean technology;

    @Column(name = "nature")
    boolean nature;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isMuseum() {
        return museum;
    }

    public void setMuseum(boolean museum) {
        this.museum = museum;
    }

    public boolean isSport() {
        return sport;
    }

    public void setSport(boolean sport) {
        this.sport = sport;
    }

    public boolean isTechnology() {
        return technology;
    }

    public void setTechnology(boolean technology) {
        this.technology = technology;
    }

    public boolean isNature() {
        return nature;
    }

    public void setNature(boolean nature) {
        this.nature = nature;
    }
}
