package br.com.mercado.mercadolivre.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathControler {
    @RequestMapping(value = "/soma/{numero1}/{numero2}", method = RequestMethod.GET)
    public Long soma(@PathVariable Long numero1, @PathVariable Long numero2){
        return numero1 + numero2;
    }
    @RequestMapping(value = "/subtracao/{numero1}/{numero2}", method = RequestMethod.GET)
    public Long subtracao(@PathVariable Long numero1, @PathVariable Long numero2){
        return numero1 - numero2;
    }
    @RequestMapping(value = "/divisao/{numero1}/{numero2}", method = RequestMethod.GET)
    public Long divisao(@PathVariable Long numero1, @PathVariable Long numero2){
        return numero1 / numero2;
    }
    @RequestMapping(value = "/multiplicacao/{numero1}/{numero2}", method = RequestMethod.GET)
    public Long multiplicacao(@PathVariable Long numero1, @PathVariable Long numero2){
        return numero1 * numero2;
    }
}
