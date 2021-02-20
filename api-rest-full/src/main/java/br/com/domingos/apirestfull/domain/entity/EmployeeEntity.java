package br.com.domingos.apirestfull.domain.entity;

import br.com.domingos.apirestfull.domain.enumeration.EmployeeStatus;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String middleName;

    private String lastName;

    private String celPhone;

    private String email;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus employeeStatus;

    @CreationTimestamp
    private LocalDateTime creationDate;

    @UpdateTimestamp
    private LocalDateTime updateDate;

}
