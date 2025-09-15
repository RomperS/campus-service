package com.olo.campusservice.infrastructure.entity;

import com.olo.campusservice.domain.model.enums.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "campus_resources")
public class CampusResourceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "campus_id")
    private CampusEntity campus;

    @ManyToOne
    @JoinColumn(name = "resource_id")
    private ResourceEntity resource;

    private int quantity;

    @Enumerated(EnumType.STRING)
    private State state;
}
