package Controllers;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {

        //Author
        get("/item", ((request, response) -> {
            return null;
        }));
        get("/item/:id", ((request, response) -> {
            return null;
        }));
        post("/item", ((request, response) -> {
            return null;
        }));
        put("/item/:id", ((request, response) -> {
            return null;
        }));
        options("/item/:id", ((request, response) -> {
            return null;
        }));
        delete("/item/:id", ((request, response) -> {
            return null;
        }));
    }


}
