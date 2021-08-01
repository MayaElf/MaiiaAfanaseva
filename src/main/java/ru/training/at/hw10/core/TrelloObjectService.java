package ru.training.at.hw10.core;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.net.URI;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import ru.training.at.hw10.beans.CardCreation;
import ru.training.at.hw10.beans.TrelloBoardModel;
import ru.training.at.hw10.beans.TrelloCardModel;
import ru.training.at.hw10.beans.TrelloListModel;
import ru.training.at.hw10.constants.ParamEnum;

public class TrelloObjectService {

    public static final URI TRELLO_URI = URI.create("https://api.trello.com/1/cards/");
    public static final URI TRELLO_URI_BOARD = URI.create("https://api.trello.com/1/boards/");
    public static final URI TRELLO_URI_LIST = URI.create("https://api.trello.com/1/lists");
    private static long requestNumber = 0L;
    private Method requestMethod;
    private String body;

    private Map<String, String> parameters;

    private TrelloObjectService(Map<String, String> parameters, Method method, String body) {
        this.parameters = parameters;
        this.requestMethod = method;
        this.body = body;
    }

    public static ApiRequestBuilder requestBuilder() {
        return new ApiRequestBuilder();
    }

    public static class ApiRequestBuilder {
        private Map<String, String> parameters = new HashMap<>();
        private Method requestMethod = Method.GET;
        private String body = "";

        public ApiRequestBuilder setMethod(Method method) {
            requestMethod = method;
            return this;
        }

        public ApiRequestBuilder setBody(String name, String id) {
            CardCreation card = new CardCreation();
            card.setIdList(id);
            card.setName(name);
            Gson cardJson = new Gson();
            body = cardJson.toJson(card, CardCreation.class);
            return this;
        }

        public ApiRequestBuilder setParams(ParamEnum[] param) {
            for (ParamEnum params : param) {
                parameters.put(String.valueOf(params).toLowerCase(Locale.ROOT), params.value);
            }
            return this;
        }

        public ApiRequestBuilder setBoardParam(String boardName) {
            parameters.put("name", boardName);
            return this;
        }

        public ApiRequestBuilder setBoardId(String boardId) {
            parameters.put("idBoard", boardId);
            return this;
        }

        public TrelloObjectService buildRequest() {
            return new TrelloObjectService(parameters, requestMethod, body);
        }
    }

    public Response sendRequest() {
        return RestAssured
            .given(requestSpecification()).log().all()
            .queryParams(parameters)
            .request(requestMethod, TRELLO_URI + TrelloDataProvider.getCardModel().getId())
            .prettyPeek();
    }

    public Response createBoardRequest() {
        Response response = RestAssured
            .given(requestSpecificationBoard()).log().all()
            .queryParams(parameters)
            .request(Method.POST, TRELLO_URI_BOARD)
            .prettyPeek();
        TrelloDataProvider.boardName = new Gson().fromJson(response.asString(), TrelloBoardModel.class)
                                                 .getName();
        TrelloDataProvider.boardId = new Gson().fromJson(response.asString(), TrelloBoardModel.class)
                                               .getId();
        return response;
    }

    public Response createCardRequest() {
        Response response = RestAssured
            .given(requestSpecificationCard()).log().all()
            .queryParams(parameters)
            .body(body)
            .request(Method.POST, TRELLO_URI)
            .prettyPeek();
        TrelloDataProvider.setCardModel(getTheOnlyAnswer(response));
        return response;
    }

    public Response deleteBoardRequest() {
        return RestAssured
            .given(requestSpecificationBoardDelete()).log().all()
            .queryParams(parameters)
            .request(Method.DELETE, TRELLO_URI_BOARD + TrelloDataProvider.boardId)
            .prettyPeek();
    }

    public Response createListRequest() {
        Response response = RestAssured
            .given(requestSpecificationList()).log().all()
            .queryParams(parameters)
            .request(Method.POST, TRELLO_URI_LIST)
            .prettyPeek();
        TrelloDataProvider.listId = new Gson().fromJson(response.asString(), TrelloListModel.class).getId();
        return response;
    }

    public static TrelloCardModel getTheOnlyAnswer(Response response) {
        TrelloCardModel answer = new Gson().fromJson(response.asString(), TrelloCardModel.class);
        return answer;
    }

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
            .setAccept(ContentType.JSON)
            .addQueryParam("requestNumber", ++requestNumber)
            .setBaseUri(TRELLO_URI + TrelloDataProvider.getCardModel().getId())
            .build();
    }

    public static RequestSpecification requestSpecificationBoardDelete() {
        return new RequestSpecBuilder()
            .setAccept(ContentType.JSON)
            .addQueryParam("requestNumber", ++requestNumber)
            .setBaseUri(TRELLO_URI_BOARD + TrelloDataProvider.boardId)
            .build();
    }

    public static RequestSpecification requestSpecificationCard() {
        return new RequestSpecBuilder()
            .setAccept(ContentType.JSON)
            .setContentType("application/json")
            .addQueryParam("requestNumber", ++requestNumber)
            .setBaseUri(TRELLO_URI)
            .build();
    }

    public static RequestSpecification requestSpecificationBoard() {
        return new RequestSpecBuilder()
            .setAccept(ContentType.TEXT)
            .setContentType("UTF-8")
            .addQueryParam("requestNumber", ++requestNumber)
            .setBaseUri(TRELLO_URI_BOARD)
            .build();
    }

    public static RequestSpecification requestSpecificationList() {
        return new RequestSpecBuilder()
            .setAccept(ContentType.TEXT)
            .setContentType("UTF-8")
            .addQueryParam("requestNumber", ++requestNumber)
            .setBaseUri(TRELLO_URI_LIST)
            .build();
    }
}
