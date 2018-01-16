package id.ac.tazkia.notification.controller;

import id.ac.tazkia.notification.dao.TemplateSmsDao;
import id.ac.tazkia.notification.entity.TemplateSms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@RequestMapping("/sms")
@Controller
public class TemSmsController {

    @Autowired
    private TemplateSmsDao ts;

    @RequestMapping("/list")
    public void  daftarSender(Model m){
        m.addAttribute("daftarTemplateSms", ts.findAll());

    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public void tampilkanForm(Model model){
        model.addAttribute("templateSms", new TemplateSms());
    }


    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String simpan(@Valid TemplateSms p, BindingResult errors){
        if(errors.hasErrors()){
            return "index";
        }
        ts.save(p);
        return "redirect:form";
    }

}
