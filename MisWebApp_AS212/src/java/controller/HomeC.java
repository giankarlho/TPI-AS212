package controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named
@RequestScoped
public class HomeC {

    private List<String> images;
    String[] apps = {"Caracol", "Cajero", "Calculadora"};

    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (String x : apps) {
            for (int i = 1; i <= 3; i++) {
                images.add(x);
            }
        }
    }
    
//     public void init() {
//        images = new ArrayList<String>();
//        for (int i = 1; i <= 3; i++) {
//            images.add("image" + i + ".jpg");
//        }
//    }

    public HomeC() {

    }

    public List<String> getImages() {
        return images;
    }

}
