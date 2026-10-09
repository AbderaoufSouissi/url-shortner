package com.ars.shortener.entity;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
@Table(name = "urls")
public class UrlEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String mainUrl;

    @Column(nullable = false, unique = true, length = 6)
    private String shortCode;

}
