package com.example.admin_doctor.models;

import com.example.admin_doctor.enums.DoctorEnum;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tg_user")
public class TelegramUserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "name")
    private String name;

    @Column(name = "telegram_username")
    private String username;

    @Column(name = "telegram_id")
    private String telegramId;

    @Column(name = "wanted_doc")
    @Enumerated
    DoctorEnum doctorEnum;
}
