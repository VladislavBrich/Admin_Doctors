package com.example.admin_doctor.repos;

import com.example.admin_doctor.models.TelegramUserModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<TelegramUserModel, Long> {
    TelegramUserModel findTelegramUserModelByTelegramId(String TelegramId);
}
