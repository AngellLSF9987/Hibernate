package com.example.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * A través de la propiedad de clase @Column podemos realizar e indicar tratamientos
     * de las columnas de la base de datos. UNIQUE, Lenght(255 cararcteres)
     **/
    @Column(length = 50, nullable = false) // Longitud máxima de 50 caracteres. El campo no puede quedar vacío.
    private String name;
    private String email;
    private LocalDate birthdate;  /** import java.time.LocalDate; */

    /**
     *  Podemos asignar directamente la estrategia indicando que el atributo birthdate
     *  tiene su propia columna pero se compone de dos palabras.
     *
     *             @Column(name = "birth_date")
     *
     **/


    /**
     * Propiedad o atributo del objeto Author pero que viene definida desde otra clase, es decir, otra tabla de la base de datos.
     * Dado que no es un atributo de tipo básico, deberemos crear un relación entre clases, tablas, entidades...
     *
     *     @ OneToOne
     *     @ OneToMany
     *     @ ManyToOne
     *     @ ManyToMany
     *
     *     En el caso de Address la relación empleada será Uno a Uno -> @OneToOne. Un Autor tiene una dirección.
     */

    @OneToOne
    @JoinColumn(name="address_id", unique =true) // Cruce de datos entre las tablas Address y Author referenciando el id de
                                                 // la tabla Address como clave foránea de la tabla Author para así disponer de
                                                 // la información del resto de campos pertenecientes a la tabla Address.
    private Address address;

    public Author(String name, String email, LocalDate birthdate) {
        this.name = name;
        this.email = email;
        this.birthdate = birthdate;
        //this.address = address;
    }

    public Author() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
