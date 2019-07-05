package br.com.schumaker.jpa.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author hudson schumaker
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() throws SQLException {
        return "home";
    }

}
