package com.homeworks.homework1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class InputControler {

    @Autowired
    SerwisRandom serwis;

//         Metody zawarte w Controllerze nie powinny być typu void, ponieważ trzeba coś zwrócić klientowi który do niego strzela.

        @GetMapping (value = "random")
        public void getDrawnNumbersListMaxMin (@RequestParam(value = "number", defaultValue = "0") int number, @RequestParam(value = "flag") String flag) {
            List<Integer> list = serwis.getDrawnNumbersList(number);
            System.err.println("Drawn numbers are: " + list);

            Integer maxMinCollections = serwis.getMinOrMaxUsageOfCollections(serwis.getDrawnNumbersList(number),flag);
            System.err.println();
            System.err.println(flag + " number is: " + maxMinCollections);

            Integer maxMinNoCollections = serwis.getMinOrMaxNoCollectionsUsage(serwis.getDrawnNumbersList(number),flag);
            System.err.println(flag + " number is: " + maxMinNoCollections);
        }


}