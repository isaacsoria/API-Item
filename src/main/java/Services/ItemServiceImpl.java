package Services;

import Domains.Item;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.http.HttpHost;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders.*;

public class ItemServiceImpl implements ItemService {

    private static HashMap<String, Item> itemMap;
    //The config parameters for the connection
    private static final String HOST = "localhost";
    private static final int PORT_ONE = 9200;
    private static final int PORT_TWO = 9201;
    private static final String SCHEME = "http";

    private static RestHighLevelClient restHighLevelClient;
    private static ObjectMapper objectMapper = new ObjectMapper();


    private static final String INDEX = "items";
    private static final String TYPE = "item";



    public ItemServiceImpl() {
        itemMap = new HashMap<>();
    }

    public void addItem(Item item) throws IOException {
        makeConnection();
//        item.setId(UUID.randomUUID().toString());
        IndexRequest indexRequest = new IndexRequest(INDEX, TYPE)
                .source(new Gson().toJson(item), XContentType.JSON);
        try {
            IndexResponse response = restHighLevelClient.index(indexRequest);
        } catch (ElasticsearchException e) {
            throw e;
        } catch (java.io.IOException ex) {
            throw ex;
        }finally {
            closeConnection();
        }
    }

    public Collection<Item> getItems() {


        return itemMap.values();
    }

    public Item getItem(String id) throws IOException {
        makeConnection();
        GetRequest getRequest = new GetRequest(INDEX, TYPE, id);
        GetResponse getResponse = null;
        try {
            getResponse = restHighLevelClient.get(getRequest);
        } catch (java.io.IOException ex) {
            throw ex;
        }finally {
            closeConnection();
        }

        return getResponse != null ?
                objectMapper.convertValue(getResponse.getSourceAsMap(), Item.class) : null;

//        return itemMap.get(id);

//        curl -X GET "localhost:9200/items/_mapping/_doc"

    }

    public Item editItem(Item forEdit) throws IOException {
        makeConnection();
        UpdateRequest updateRequest = new UpdateRequest(INDEX, TYPE, forEdit.getId())
                .fetchSource(true);    // Fetch Object after its update
        try {
            updateRequest.doc(new Gson().toJson(forEdit), XContentType.JSON);
            UpdateResponse updateResponse = restHighLevelClient.update(updateRequest);
            return objectMapper.convertValue(updateResponse.getGetResult().sourceAsMap(), Item.class);
        } catch (JsonProcessingException e) {
            throw e;
        } catch (java.io.IOException e) {
            throw e;
        }finally {
            closeConnection();
        }


//        try {
//
//            Item toEdit = itemMap.get(forEdit.getId());
//
////            if (toEdit == null)
////                throw new UsuarioException("Eemplo.Usuario no encontrado");
//
//            if (forEdit.getAvalible_quantity() != null) {
//                toEdit.setAvalible_quantity(forEdit.getAvalible_quantity());
//            }
//            if (forEdit.getBuying_mode() != null) {
//                toEdit.setBuying_mode(forEdit.getBuying_mode());
//            }
//            if (forEdit.getCategory_id() != null) {
//                toEdit.setCategory_id(forEdit.getCategory_id());
//            }
//            if (forEdit.getCondition() != null) {
//                toEdit.setCondition(forEdit.getCondition());
//            }
//            if (forEdit.getCurrency_id() != null) {
//                toEdit.setCurrency_id(forEdit.getCurrency_id());
//            }
//            if (forEdit.getDescription() != null) {
//                toEdit.setDescription(forEdit.getDescription());
//            }
//            if (forEdit.getId() != null) {
//                toEdit.setId(forEdit.getId());
//            }
//            if (forEdit.getListing_type_id() != null) {
//                toEdit.setListing_type_id(forEdit.getListing_type_id());
//            }
//
//            return toEdit;
//        } catch (Exception ex) {
//            throw ex;
//        }
    }

    public void deleteItem(String id) throws IOException {
        makeConnection();

        DeleteRequest deleteRequest = new DeleteRequest(INDEX, TYPE, id);
        try {
            DeleteResponse deleteResponse = restHighLevelClient.delete(deleteRequest);
        } catch (java.io.IOException e) {
            throw e;
        }finally {
            closeConnection();
        }
    }

    public boolean itemExist(String id) {
        return false;
    }


    private static synchronized RestHighLevelClient makeConnection() {

        if (restHighLevelClient == null) {
            restHighLevelClient = new RestHighLevelClient(
                    RestClient.builder(
                            new HttpHost(HOST, PORT_ONE, SCHEME),
                            new HttpHost(HOST, PORT_TWO, SCHEME)));
        }

        return restHighLevelClient;
    }

    private static synchronized void closeConnection() throws IOException {
        restHighLevelClient.close();
        restHighLevelClient = null;
    }
}
