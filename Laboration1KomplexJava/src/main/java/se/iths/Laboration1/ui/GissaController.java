package se.iths.Laboration1.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.iths.Laboration1.business.GissaService;

@Controller
public class GissaController {

    @Autowired
    GissaService gissaService = new GissaService();

    @PostMapping("/login")
    public String login(@RequestParam("playername") String pName){
        gissaService.login(pName);
        return "gissapage";
    }

    @PostMapping("/gissa")
    public String fillForm(@RequestParam("gissning") int guess, Model m){
        String svar = gissaService.gissa(guess);
        m.addAttribute("reply", svar);
        return "gissapage";
    }

    @GetMapping("/toplist")
    public String getTopList(Model m){
        m.addAttribute("toplist", gissaService.getTopList());
        return "toppage";
    }

}
