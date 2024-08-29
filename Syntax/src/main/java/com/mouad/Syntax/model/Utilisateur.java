package com.mouad.Syntax.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
public class Utilisateur extends Personne{

    @OneToMany(mappedBy = "utilisateur")
    @JsonIgnore
    List<Certificat> certificats;
}
