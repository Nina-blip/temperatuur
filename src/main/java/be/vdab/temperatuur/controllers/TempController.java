package be.vdab.temperatuur.controllers;

import be.vdab.temperatuur.restclients.OWRestClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/temperatuur")
public class TempController {
    private final OWRestClient client;

    public TempController(OWRestClient client) {
        this.client = client;
    }


    @GetMapping
    public ModelAndView vindTemp(){
        var model = new ModelAndView("temperatuur");
        client.findByGemeente("Turnhout").ifPresent(temp -> model.addObject("tempGemeente",temp));
        return model;
    }
}
