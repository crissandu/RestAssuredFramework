package resources;

import bdd.pojo.AddPlace;
import bdd.pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {


    public AddPlace addPlacePayload(String name, String language, String address){

        List<String> types = new ArrayList<>();
        types.add("shoe park");
        types.add("park");
        Location location = new Location();
        location.setLat(-38.383494);
        location.setLng(33.427362);
        AddPlace addPlace = new AddPlace();
        addPlace.setAccuracy(50);
        addPlace.setLanguage(language);
        addPlace.setName(name);
        addPlace.setPhoneNumber(address);
        addPlace.setWebsite("http://google.com");
        addPlace.setLocation(location);
        addPlace.setType(types);

        return addPlace;


    }





}
