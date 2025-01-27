package com.example.Task.Manager.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customer_details")
public class Customer {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id",updatable = false,nullable = false)
    private long Id;

    @Column(name = "customer_name",nullable = false)
    private String name;

    @Column(name = "customer_email",nullable = false)
    private String email;

    @Column(name = "customer_dob",nullable = false)
    private LocalDate dob;

    @Column(name = "customer_phone_Number",nullable = false)
    private String phoneNumber;

    @Column(name = "is_archived",nullable = false)
    private Boolean isArchived = false;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    @ToString.Exclude
    @OneToMany(
            mappedBy = "customer_details",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    //@JoinColumn(name="customer_id",referencedColumnName = "customer_id")
    private List<Task> task = new ArrayList<>();


}
