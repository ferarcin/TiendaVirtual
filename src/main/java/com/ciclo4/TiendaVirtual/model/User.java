package com.ciclo4.TiendaVirtual.model;

import java.io.Serializable;
import javax.persistence.*;
/*import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;*/
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "user", indexes = @Index(name = "index_email", columnList = "email", unique = true))
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(name= "email", nullable = false, length = 50)
    private String email;

    @NonNull
    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @NonNull
    @Column(name = "name", nullable = false, length = 80)
    private String name;

}
