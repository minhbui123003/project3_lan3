package com.javaweb.entity;

import javax.persistence.*;

@Entity
@Table(name = "rentarea")
public class RentAreaEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "value")
    private String value;

    @ManyToOne
    @JoinColumn(name = "buildingid")
    private BuildingEntity building;

    @Override
    public Long getId() {
        return Id;
    }

    @Override
    public void setId(Long id) {
        Id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public BuildingEntity getBuilding() {
        return building;
    }

    public void setBuilding(BuildingEntity building) {
        this.building = building;
    }
}
