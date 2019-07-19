package tests;

import core.BaseTest;
import org.testng.annotations.Test;
import pageObject.BoardsPage;
import services.TrelloService;

/**
 * @author Pavel_Chaika
 */

public class TrelloSystemTest extends BaseTest {

    @Test()
    public void createNewBoard() {

        BoardsPage boardsPage = new BoardsPage(driver);
        TrelloService service = new TrelloService(driver);

        boardsPage.openBoardPage();
        service.createNewBoard();
    }
}