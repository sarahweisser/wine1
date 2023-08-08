package com.wineApi.wine1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "appellations")
public class Appellation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appellation_id")
    private Long appellationId;

    // TODO add unique constraint
    @NotBlank
    @Column(name = "appellation_name")
    private String appellationName;

    @JsonIgnore
    @Column(name = "appellation_description")
    private String appellationDescription;

    public Appellation(Long appellationId, String appellationName, String appellationDescription) {
        this.appellationId = appellationId;
        this.appellationName = appellationName;
        this.appellationDescription = appellationDescription;
    }

    public Appellation() {
    }

    public Long getAppellationId() {
        return appellationId;
    }

    public void setAppellationId(Long appellationId) {
        this.appellationId = appellationId;
    }

    public String getAppellationName() {
        return appellationName;
    }

    public void setAppellationName(String appellationName) {
        this.appellationName = appellationName;
    }

    public String getAppellationDescription() {
        return appellationDescription;
    }

    public void setAppellationDescription(String appellationDescription) {
        this.appellationDescription = appellationDescription;
    }
}
