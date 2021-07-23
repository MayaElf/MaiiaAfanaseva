package ru.training.at.hw10.core;


import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThan;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.http.HttpStatus;
import org.hamcrest.MatcherAssert;
import ru.training.at.hw10.beans.TrelloAnswer;
import ru.training.at.hw10.constants.ParamEnum;

public class TrelloObjectService {
    public static final URI TRELLO_URI = URI.create("https://api.trello.com/1/cards/60fab7502704620ea6d6f60f?"
        + "key=c7a7b24dcc0b4a65bc473bb5445d772a&token=72dad"
        + "4fafb20bafd224c65d250f8641c877481a48340d54986a308a3289df8e1&name=HW9-POSTMAN");
    private static long requestNumber = 0L;
    private Method requestMethod;

    private Map<String, String> parameters;

    private TrelloObjectService(Map<String, String> parameters, Method method) {
        this.parameters = parameters;
        this.requestMethod = method;
    }

    public static ApiRequestBuilder requestBuilder() {
        return new ApiRequestBuilder();
    }

    public static class ApiRequestBuilder {
        private Map<String, String> parameters = new HashMap<>();
        private Method requestMethod = Method.GET;

        public ApiRequestBuilder setMethod(Method method) {
            requestMethod = method;
            return this;
        }

        public ApiRequestBuilder setParams(ParamEnum[] param) {
            for (ParamEnum params : param) {
                parameters.put(String.valueOf(params), params.value);
            }
            return this;
        }

        public TrelloObjectService buildRequest() {
            return new TrelloObjectService(parameters, requestMethod);
        }
    }

    public Response sendRequest() {
        return RestAssured
            .given(requestSpecification()).log().all()
            .queryParams(parameters)
            .request(requestMethod, TRELLO_URI)
            .prettyPeek();
    }

    public static TrelloAnswer getTheOnlyAnswer(Response response) {
        String temp = response.asString();
        TrelloAnswer answer = new Gson().fromJson(response.asString(), TrelloAnswer.class);
        //MatcherAssert.assertThat("We expect to get one answer, but got" + answers.size(), answers, hasSize(1));
        return answer;
    }

    public static List<TrelloAnswer> getAnswers(Response response) {
        List<TrelloAnswer> answers = new Gson()
            .fromJson(response.asString().trim(), new TypeToken<List<TrelloAnswer>>() {
            }.getType());
        return answers;
    }

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
            .setAccept(ContentType.JSON)
            .addQueryParam("requestNumber", ++requestNumber)
            .setBaseUri(TRELLO_URI)
            .build();
    }
}
