package com.example.admin_doctor.repos;

import com.example.admin_doctor.enums.DoctorEnum;
import com.example.admin_doctor.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<BookModel, Long> {
    List<BookModel> findBookModelsByDoctorEnum(DoctorEnum d);
}
