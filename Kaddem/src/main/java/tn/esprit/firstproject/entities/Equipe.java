package tn.esprit.firstproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Equipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idEquipe;
    String nomEqupe;
    @Enumerated(EnumType.STRING)
    Niveau niveau;

    @ManyToMany(mappedBy = "equipes")
    @JsonIgnore
    Set<Etudiant> etudiants;

    @OneToOne(mappedBy = "equipe", cascade = CascadeType.PERSIST)
    DetailEquipe detailEquipe;
}
