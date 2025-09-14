package com.olo.campusservice.infrastructure.entity;

import com.olo.campusservice.domain.model.enums.Shift;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "campuses")
public class CampusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;

    @ElementCollection(targetClass = Shift.class, fetch = FetchType.EAGER)
    @CollectionTable(
            name = "campus_shifts",
            joinColumns = @JoinColumn(name = "campus_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "shift")
    private Set<Shift> shifts = new HashSet<>();
}