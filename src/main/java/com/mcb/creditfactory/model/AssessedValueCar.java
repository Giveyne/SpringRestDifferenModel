package com.mcb.creditfactory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ASSESSED_VALUE_CAR")
public class AssessedValueCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "assessed_value")
    private BigDecimal value;

    private LocalDate assessedDate;

    @ManyToOne
    @JoinColumn(name = "car_id")
    @JsonIgnore
    private Car car;

}
