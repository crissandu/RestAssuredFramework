package resources;

// enum is special class in Java which has collection of constants and methods

public enum APIResources {

    AddPlaceAPI("/maps/api/place/add/json"), //this is a method in enum
    GetPlaceAPI("/maps/api/place/get/json"),
    DeletePlaceApi("/maps/api/place/delete/json");
    private String resource;

    APIResources(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }

}
