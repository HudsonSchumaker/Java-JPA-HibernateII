package br.com.schumaker.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author hudson schumaker
 */
@Controller
@RequestMapping("/loja")
public class LojaController {

    @RequestMapping("/form")
    public String form() {
        return "loja/form";
    }
}
