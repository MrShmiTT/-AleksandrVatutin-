package com.epam.tc.hw9;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static service.ServiceObject.requestBuilder;
import static util.Constants.BOARD_URI;
import static util.Constants.KEY;
import static util.Constants.NEW_BOARD_NAME;
import static util.Constants.TOKEN;

import beans.Board;
import io.restassured.http.Method;
import org.testng.annotations.Test;
import steps.BoardSteps;

public class BoardTests extends BaseTest {

    @Test
    public void isBoardCreated() {
        assertThat(board, allOf(hasProperty("id"), hasProperty("name")));
    }

    @Test
    public void isBoardDeleted() {
        BoardSteps.deleteBoardStep(board.getId());

        requestBuilder()
            .setMethod(Method.GET)
            .buildRequest()
            .sendRequest(BOARD_URI + board.getId())
            .then().assertThat()
            .body(containsString("The requested resource was not found."));
        assertThat(board.getName(), containsString("asd"));
    }

    @Test
    public void isBoardNameChanged() {
        Board newBoard = BoardSteps.changeBoardNameStep(board.getId(), NEW_BOARD_NAME);
        assertThat(newBoard.getName(), equalTo(NEW_BOARD_NAME));
    }

    @Test
    public void getBoards() {
        requestBuilder()
            .setMethod(Method.GET)
            .setCredentials(KEY, TOKEN)
            .buildRequest()
            .sendRequest("https://api.trello.com/1/members/me/boards/");
    }
}
