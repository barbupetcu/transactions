package com.transactions.persistence.model;

import javax.persistence.*;

/*
* Din structura raportului inteleg ca o persoana poate avea un singur cont(voi merge pe aceasta varianta pentru a simplifica schema Entitatilor)
* In cazul in care o persoana poate avea mai multe conturi:
*
    * - se creeaza o alta entitate Account in care se vor muta: IBAN,
    * - entitatea Account va contine o coloana de legatura cu TransactionActor (@ManyToOne)
    * - in entitatea Transaction coloanele payer si payee nu vor mai contine TransactionActor, ci Account
 */

@Entity
@Table(name = "PERSONS")
public class TransactionActor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="id_persons_seq")
    @SequenceGenerator(name="id_persons_seq", sequenceName = "id_persons_seq", allocationSize=1)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "CNP", nullable = false, length = 13, unique = true)
    private String cnp;

    @Column(name = "IBAN", nullable = false, length = 26, unique = true)
    private String iban;

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

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

}
