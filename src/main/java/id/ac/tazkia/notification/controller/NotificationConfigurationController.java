package id.ac.tazkia.notification.controller;

import id.ac.tazkia.notification.dao.NotificationConfigurationDao;
import id.ac.tazkia.notification.entity.NotificationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@RequestMapping("/notifikasikonfigurasi")
@Controller
public class NotificationConfigurationController {

    @Autowired
    private NotificationConfigurationDao nc;

    @RequestMapping("/list")
    public void  daftarSender(Model m){
        m.addAttribute("daftarNotifikasiKonfigurasi", nc.findAll());

    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public void tampilkanForm(Model model){
        model.addAttribute("notificationConfiguration", new NotificationConfiguration());
    }


    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String simpan(@Valid NotificationConfiguration p, BindingResult errors){
        if(errors.hasErrors()){
            return "index";
        }
        nc.save(p);
        return "redirect:form";
    }

}
