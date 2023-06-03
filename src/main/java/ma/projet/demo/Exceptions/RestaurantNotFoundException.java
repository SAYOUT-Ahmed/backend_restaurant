package ma.projet.demo.Exceptions;

public class RestaurantNotFoundException extends RuntimeException{


    public RestaurantNotFoundException(int id){
        super("Restaurant n'existe pas!");
    }

}
