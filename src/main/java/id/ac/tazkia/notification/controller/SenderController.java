package id.ac.tazkia.notification.controller;


import id.ac.tazkia.notification.dao.SenderDao;
import id.ac.tazkia.notification.entity.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@RequestMapping("/sender")
@Controller
public class SenderController {

    @Autowired
    private SenderDao sd;

    @RequestMapping("/list")
    public void  daftarSender(Model m){
        m.addAttribute("daftarSender", sd.findAll());

    }

    /*@RequestMapping("/hapus")
    public  String hapus(@RequestParam("id") String id ){
        sd.delete(id);
        return "redirect:list";
    }
*/
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public void tampilkanForm(Model model){
        model.addAttribute("sender", new Sender());
    }


    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String simpan(@Valid Sender p, BindingResult errors){
        if(errors.hasErrors()){
            return "index";
        }
        sd.save(p);
        return "redirect:form";
    }


   /* @GetMapping("/list")
    public void listPage(){

    }*/

}
