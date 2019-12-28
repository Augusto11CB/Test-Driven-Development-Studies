package com.isbn.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class StockManagerTest {

    private ExternalISBNDataService dataService;
    private ExternalISBNDataService databaseService;
    private ExternalISBNDataService webService;
    private StockManager stockManager;
    private Book book;

    @BeforeEach
    private void init() {
        this.dataService = mock(ExternalISBNDataService.class);
        this.databaseService = mock(ExternalISBNDataService.class);
        this.webService = mock(ExternalISBNDataService.class);

        this.stockManager = new StockManager();
        this.book = new Book("0140177396", "abc", "abc");
    }

    @Test
    void databaseIsUsedIfDataIsPresent() {

        when(dataService.lookup(any())).thenReturn(book);

        stockManager.setDataBaseService(dataService);
        stockManager.setService(dataService);

        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);

        verify(dataService, atMostOnce()).lookup(anyString());

    }

    @Test
    public void webserviceIsUsedIfDataIsNotPresentInDatabase() {


        when(databaseService.lookup(any())).thenReturn(null);
        when(webService.lookup(any())).thenReturn(book);

        stockManager.setDataBaseService(databaseService);
        stockManager.setService(webService);


        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);

        verify(databaseService).lookup("0140177396");
        verify(webService).lookup("0140177396");
    }
}
