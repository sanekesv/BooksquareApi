package ru.kpfu.itis.model;

import javax.persistence.*;

/**
 * Created by sanekesv on 22.03.16.
 */
@Entity
@SequenceGenerator(name = "location_gen", sequenceName = "location_seq")
@Table(name = "location")
public class Location {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_gen")
    private Long id;

    private String name;

    private Double lat;

    private Double lng;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
