package ru.training.at.hw10;


import static ru.training.at.hw10.core.TrelloObjectService.getTheOnlyAnswer;
import static ru.training.at.hw10.core.TrelloObjectService.requestBuilder;

import io.restassured.http.Method;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.training.at.hw10.beans.TrelloCardModel;
import ru.training.at.hw10.constants.CardEnum;
import ru.training.at.hw10.constants.ListEnum;
import ru.training.at.hw10.constants.ParamEnum;
import ru.training.at.hw10.core.TrelloDataProvider;

public class TrelloTests {

    @BeforeTest
    public void beforeTest() {

        requestBuilder()
            .setParams(ParamEnum.values())
            .setMethod(Method.POST)
            .buildRequest()
            .createBoardRequest();

        requestBuilder()
            .setParams(ParamEnum.values())
            .setBoardId(TrelloDataProvider.boardId)
            .setBoardParam(ListEnum.LIST.getText())
            .setMethod(Method.POST)
            .buildRequest()
            .createListRequest();

        requestBuilder()
            .setParams(ParamEnum.values())
            .setBoardParam(TrelloDataProvider.boardName)
            .setBody(CardEnum.CARD.getText(), TrelloDataProvider.listId)
            .setMethod(Method.POST)
            .buildRequest()
            .createCardRequest();
    }

    @AfterTest
    public void afterTest() {
        requestBuilder()
            .setParams(ParamEnum.values())
            .setMethod(Method.DELETE)
            .buildRequest()
            .deleteBoardRequest();
    }

    @Test(dataProvider = "cardNameDataProvider",
          dataProviderClass = TrelloDataProvider.class)
    public void checkCardName(String cardName, ParamEnum[] paramEnums) {
        TrelloCardModel result = getTheOnlyAnswer(
            requestBuilder()
                .setParams(paramEnums)
                .buildRequest()
                .sendRequest());
        MatcherAssert.assertThat("API reported correct name of the card: " + result,
            result.getName().contains(cardName));
    }

    @Test(dataProvider = "cardDescDataProvider",
          dataProviderClass = TrelloDataProvider.class)
    public void checkCardDesc(String cardDesc, ParamEnum[] paramEnums) {
        TrelloCardModel result = getTheOnlyAnswer(
            requestBuilder()
                .setParams(paramEnums)
                .buildRequest()
                .sendRequest());
        MatcherAssert.assertThat("API reported correct description of the card: " + result,
            result.getDesc().contains(cardDesc));
    }

    @Test(dataProvider = "simpleDataProvider",
          dataProviderClass = TrelloDataProvider.class)
    public void cardShortUrlContainsLink(ParamEnum[] paramEnums) {
        TrelloCardModel result = getTheOnlyAnswer(
            requestBuilder()
                .setParams(paramEnums)
                .buildRequest()
                .sendRequest());
        MatcherAssert.assertThat("API reported short url contains link: " + result,
            result.getShortUrl().contains(result.getShortLink()));
    }

    @Test(dataProvider = "cardIdBoardDataProvider",
          dataProviderClass = TrelloDataProvider.class)
    public void checkIdBoard(String id, ParamEnum[] paramEnums) {
        TrelloCardModel result = getTheOnlyAnswer(
            requestBuilder()
                .setParams(paramEnums)
                .buildRequest()
                .sendRequest());
        MatcherAssert.assertThat("API reported IdBoard is correct: " + result,
            result.getIdBoard().equals(id));
    }

    @Test(dataProvider = "cardIdListDataProvider",
          dataProviderClass = TrelloDataProvider.class)
    public void checkIdList(String id, ParamEnum[] paramEnums) {
        TrelloCardModel result = getTheOnlyAnswer(
            requestBuilder()
                .setParams(paramEnums)
                .buildRequest()
                .sendRequest());
        MatcherAssert.assertThat("API reported IdList is correct: " + result,
            result.getIdList().equals(id));
    }

    @Test(dataProvider = "simpleDataProvider",
          dataProviderClass = TrelloDataProvider.class)
    public void cardUrlContainsLink(ParamEnum[] paramEnums) {
        TrelloCardModel result = getTheOnlyAnswer(
            requestBuilder()
                .setParams(paramEnums)
                .buildRequest()
                .sendRequest());
        MatcherAssert.assertThat("API reported card url contains link: " + result,
            result.getUrl().contains(result.getShortLink()));
    }

    @Test(dataProvider = "falseDataProvider",
          dataProviderClass = TrelloDataProvider.class)
    public void cardIsOpen(boolean isOpened, ParamEnum[] paramEnums) {
        TrelloCardModel result = getTheOnlyAnswer(
            requestBuilder()
                .setParams(paramEnums)
                .buildRequest()
                .sendRequest());
        MatcherAssert.assertThat("API reported card is opened: " + result,
            result.getIsClosed() == isOpened);
    }

    @Test(dataProvider = "falseDataProvider",
          dataProviderClass = TrelloDataProvider.class)
    public void cardTemplate(boolean isTemplate, ParamEnum[] paramEnums) {
        TrelloCardModel result = getTheOnlyAnswer(
            requestBuilder()
                .setParams(paramEnums)
                .buildRequest()
                .sendRequest());
        MatcherAssert.assertThat("API reported card is not template: " + result,
            result.getIsTemplate() == isTemplate);
    }

    @Test(dataProvider = "falseDataProvider",
          dataProviderClass = TrelloDataProvider.class)
    public void cardManualAttachment(boolean manualAttachment, ParamEnum[] paramEnums) {
        TrelloCardModel result = getTheOnlyAnswer(
            requestBuilder()
                .setParams(paramEnums)
                .buildRequest()
                .sendRequest());
        MatcherAssert.assertThat("API reported card has no manual cover attachment: " + result,
            result.getManualAttachment() == manualAttachment);
    }

    @Test(dataProvider = "simpleDataProvider",
          dataProviderClass = TrelloDataProvider.class)
    public void cardUrlConatainsShortUrl(ParamEnum[] paramEnums) {
        TrelloCardModel result = getTheOnlyAnswer(
            requestBuilder()
                .setParams(paramEnums)
                .buildRequest()
                .sendRequest());
        MatcherAssert.assertThat("API reported url contains short url: " + result,
            result.getUrl().contains(result.getShortUrl()));
    }
}
