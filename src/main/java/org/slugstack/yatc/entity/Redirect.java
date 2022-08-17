package org.slugstack.yatc.entity;

import lombok.*;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Redirect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;

    @NonNull
    @Column(unique = true, nullable = false)
    private String alias;

    @NonNull
    @URL
    @Column(nullable = false)
    private String url;
}
