package com.lucasangelo.todosimple.model;
import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;


@Entity
@Table(name = User.TABLE_NAME)
public class User {

    public interface CreateUser{}
    public interface UpdateUser {}

    public static final String TABLE_NAME = "user";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;
    
    @Column(name = "username", length = 100, nullable = false, unique = true)
    //@NotNull
    //@NotEmpty
    @NotBlank(groups = CreateUser.class)//Faz a validação de empty e null ao mesmo tempo
    @Size(groups = CreateUser.class, min = 8, max = 30)
    private String username;

    @Column(name = "passord", length = 15, nullable = false)
    @NotBlank(groups = { CreateUser.class, UpdateUser.class })
    @Size(groups = { CreateUser.class, UpdateUser.class }, min = 8, max = 15)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Task> tasks = new ArrayList<Task>();

}
