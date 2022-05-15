package com.example.demo.Entity;


import javax.persistence.*;


@Entity
@Table(name = "demotab")

public class DemoEntity {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Basic(optional = false)
     @Column(name = "id",unique = true,nullable = false)
     private Integer id;
     @Column
     private String nombre;

     public DemoEntity(){

     }

     public DemoEntity(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        }

     public Integer getId() {
        return id;
        }

     public void setId(Integer id) {
        this.id = id;
        }

     public String getNombre() {
        return nombre;
        }

     public void setNombre(String nombre) {
         this.nombre = nombre;
     }
}


