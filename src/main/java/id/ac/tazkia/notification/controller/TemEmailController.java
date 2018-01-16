package id.ac.tazkia.notification.controller;

import id.ac.tazkia.notification.dao.TemplateEmailDao;
import id.ac.tazkia.notification.entity.TemplateEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@RequestMapping("/email")
@Controller
public class TemEmailController {

    @Autowired
    private TemplateEmailDao te;

    @RequestMapping("/list")
    public void  daftarSender(Model m){
        m.addAttribute("daftarTemplateEmail", te.findAll());

    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public void tampilkanForm(Model model){
        model.addAttribute("templateEmail", new TemplateEmail());
    }


    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String simpan(@Valid TemplateEmail p, BindingResult errors){
        if(errors.hasErrors()){
            return "index";
        }
        te.save(p);
        return "redirect:form";
    }
}
