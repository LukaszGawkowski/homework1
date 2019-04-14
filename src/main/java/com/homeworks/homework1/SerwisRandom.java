package com.homeworks.homework1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class SerwisRandom {

        // czy mozona uzywac w nazwach metod slow get/set? Czy nie wprowadzaja w blad czytelnika (ref. settery i gettery zmiennych)

        public List<Integer> getDrawnNumbersList(int x) {

            if (x > 0) {
                int drawnNumber;
                Random r = new Random();
                List<Integer> drawnNumbersList = new ArrayList<Integer>();

                for (int n = 1; n <= x; n++) {
                    drawnNumber = r.nextInt(1000);
                    drawnNumbersList.add(drawnNumber);
                }

                return drawnNumbersList;

            } else throw new IllegalArgumentException("Provided number is not positive!");
        }
        
        public Integer getMinOrMaxUsageOfCollections (List<Integer> list, String flag){

            List<Integer> drawnList = list;

            Integer x;
            if("max".equals(flag)){
                x = Collections.max(drawnList);
            } else if ("min".equals(flag)){
                x = Collections.min(drawnList);
            } else throw new IllegalArgumentException("Provided flag must be: max/min!");

            return x;
        }

        public Integer getMinOrMaxNoCollectionsUsage (List<Integer> list, String flag){

            List<Integer> drawnList = list;

            Integer y = drawnList.get(0);

            if("max".equals(flag)){
                for(int n = 0; n <= drawnList.size(); n++) {
                    if (y <= drawnList.get(n)) {
                        y = drawnList.get(n);
                    }
                }
            } else if ("min".equals(flag)){

                for(int n = 0; n <= drawnList.size(); n++) {
                    if (y >= drawnList.get(n)) {
                        y = drawnList.get(n);
                    }
                }

            }else throw new IllegalArgumentException("Provided flag must be: max/min!");

            return y;
        }


}
