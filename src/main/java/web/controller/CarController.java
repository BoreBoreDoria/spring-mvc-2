package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @GetMapping("/cars")
    public String printCarList(@RequestParam(value = "locale", required = false) String isLocale, ModelMap model) {
        CarService carService = new CarService();
        model.addAttribute("carsList", carService.getListCar());
        System.out.println(isLocale);
        if (!(isLocale == null) && (isLocale.equals("ru"))){
            model.addAttribute("locale", "МАШИНЫ");
        } else {
            model.addAttribute("locale", "CARS");
        }
        return "cars";
    }
}
