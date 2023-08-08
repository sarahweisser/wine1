package com.wineApi.wine1.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "varietals")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Varietal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "varietal_id")
    private Long varietalId;

    // TODO add unique constraint
    @Column(name = "varietal_name")
    @NotBlank
    private String varietalName;

    @Column(name = "varietal_description")
    private String varietalDescription;

    public Varietal(Long varietalId, String varietalName, String varietalDescription) {
        this.varietalId = varietalId;
        this.varietalName = varietalName;
        this.varietalDescription = varietalDescription;
    }

    public Varietal() {
    }

    public Long getVarietalId() {
        return varietalId;
    }

    public void setVarietalId(Long varietalId) {
        this.varietalId = varietalId;
    }

    public String getVarietalName() {
        return varietalName;
    }

    public void setVarietalName(String varietalName) {
        this.varietalName = varietalName;
    }

    public String getVarietalDescription() {
        return varietalDescription;
    }

    public void setVarietalDescription(String varietalDescription) {
        this.varietalDescription = varietalDescription;
    }
}
