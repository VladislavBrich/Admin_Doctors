package com.example.admin_doctor.models;

import com.example.admin_doctor.enums.DoctorEnum;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Data
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "type")
    @Enumerated
    DoctorEnum doctorEnum;

    @Column(name = "time")
    String time;

    @Column (name = "tg_id")
    String tgId;


}