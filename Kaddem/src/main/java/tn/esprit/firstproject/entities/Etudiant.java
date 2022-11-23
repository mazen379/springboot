package tn.esprit.firstproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
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
@RequiredArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idEtudiant;
    @NotNull
    String prenomE;
    @NotNull
    String nomE;
    @Enumerated(EnumType.STRING)
    Option option;

    @OneToMany(mappedBy = "etudiant")
    @JsonIgnore
    Set<Contrat> contrats;

    @ManyToOne(cascade = CascadeType.ALL)
    Departement departement;

    @ManyToMany(/*cascade = CascadeType.ALL,fetch = FetchType.EAGER*/)
    Set<Equipe> equipes;
}
