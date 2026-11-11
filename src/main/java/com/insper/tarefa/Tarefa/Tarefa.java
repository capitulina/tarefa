package com.insper.tarefa.Tarefa;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@Table (name = "Tarefa")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String titulo;
    @Column
    private String descricao;
    @Column
    private String prioridade;
    @Column
    private String email;
}
