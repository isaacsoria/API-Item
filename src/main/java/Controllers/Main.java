package Controllers;

import Domains.Item;
import Services.ItemService;
import Services.ItemServiceImpl;
import Utilities.StandardResponse;
import Utilities.StatusResponse;
import com.google.gson.Gson;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {

        port(8080);

        final ItemService itemService = new ItemServiceImpl();

        get("/item", (request, response) -> {
            try {
                return new Gson().toJson(itemService.getItems());
            }catch(Exception  ex){
                return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS));
            }
        });
        get("/item/:id", ((request, response) -> {
            String id = request.params(":id");
            return new Gson().toJson(itemService.getItem(id));
        }));
        post("/item", ((request, response) -> {
            response.type("aplication/json");
            Item item = new Gson().fromJson(request.body(), Item.class);


            itemService.addItem(item);
            return new Gson().toJson(item);
        }));
        put("/item/:id", ((request, response) -> {

            String id = request.params(":id");
            Item item = new Gson().fromJson(request.body(), Item.class);
            itemService.editItem(itemService.getItem(id));
            return new Gson().toJson(item);
        }));
        options("/item/:id", ((request, response) -> {
            return null;
        }));
        delete("/item/:id", ((request, response) -> {
            return null;
        }));
    }


}
