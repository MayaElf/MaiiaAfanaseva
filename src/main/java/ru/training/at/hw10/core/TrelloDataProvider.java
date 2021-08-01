package ru.training.at.hw10.core;

import org.testng.annotations.DataProvider;
import ru.training.at.hw10.beans.TrelloCardModel;
import ru.training.at.hw10.constants.CardEnum;
import ru.training.at.hw10.constants.ParamEnum;

public class TrelloDataProvider {

    public static String boardName;
    public static String boardId;
    public static String listId;
    private static TrelloCardModel cardModel;

    public static void setCardModel(TrelloCardModel cardModels) {
        cardModel = cardModels;
    }

    public static TrelloCardModel getCardModel() {
        return cardModel;
    }

    @DataProvider
    public Object[][] createCardDataProvider() {
        return new Object[][] {
            {boardName, ParamEnum.values(), CardEnum.CARD.getText(), listId}
        };
    }

    @DataProvider
    public Object[][] cardNameDataProvider() {
        return new Object[][] {
            {cardModel.getName(), ParamEnum.values()}
        };
    }

    @DataProvider
    public Object[][] cardDescDataProvider() {
        return new Object[][] {
            {cardModel.getDesc(), ParamEnum.values()}
        };
    }

    @DataProvider
    public Object[][] simpleDataProvider() {
        return new Object[][] {
            {ParamEnum.values()}
        };
    }

    @DataProvider
    public Object[][] cardIdBoardDataProvider() {
        return new Object[][] {
            {cardModel.getIdBoard(), ParamEnum.values()}
        };
    }

    @DataProvider
    public Object[][] cardIdListDataProvider() {
        return new Object[][] {
            {cardModel.getIdList(), ParamEnum.values()}
        };
    }

    @DataProvider
    public Object[][] falseDataProvider() {
        return new Object[][] {
            {false, ParamEnum.values()}
        };
    }
}
