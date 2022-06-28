package com.example.admin_doctor.controllers;

import com.example.admin_doctor.enums.DoctorEnum;
import com.example.admin_doctor.models.BookModel;
import com.example.admin_doctor.models.FinBookModel;
import com.example.admin_doctor.models.TelegramUserModel;
import com.example.admin_doctor.repos.BookRepo;
import com.example.admin_doctor.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/terapevt")
public class TerapevtController {

    @Autowired
    BookRepo bookRepo;

    @Autowired
    UserRepo userRepo;

    @GetMapping
    public String getMainPage(Model model){
        List<BookModel> bookModelList =
                bookRepo.findBookModelsByDoctorEnum(DoctorEnum.TERAPEVT);
        List<TelegramUserModel> telegramUserModels = new ArrayList<>();

        for (BookModel b : bookModelList){
            telegramUserModels.add(userRepo.
                    findTelegramUserModelByTelegramId(b.getTgId()));
        }

        List<FinBookModel> list = new ArrayList<>();

        for (int i = 0; i < bookModelList.size(); i++) {
            FinBookModel finBookModel = new FinBookModel();
            finBookModel.setId(bookModelList.get(i).getId());
            finBookModel.setTime(bookModelList.get(i).getTime());
          /*  finBookModel.setUsername(userRepo.findTelegramUserModelByTelegramId(bookModelList.get(i).getTgId()).getUsername());*/
            list.add(finBookModel);
        }
        model.addAttribute("books", list);
        return "terapevt";
    }
    @GetMapping("/{id}")
    public RedirectView deleteBook(@PathVariable(value = "id") long id){
        bookRepo.deleteById(id);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/terapevt");
        return redirectView;
    }

}
