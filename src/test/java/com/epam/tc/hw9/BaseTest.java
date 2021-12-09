package com.epam.tc.hw9;

import beans.Board;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.BoardSteps;

public class BaseTest {
    protected Board board;
    protected String currentBoardId;

    @BeforeMethod
    public void setUp() {
        board = BoardSteps.createBoardStep();
        currentBoardId = board.getId();
    }

    @AfterMethod
    public void clean() {
        BoardSteps.deleteBoardStep(currentBoardId);
    }
}
