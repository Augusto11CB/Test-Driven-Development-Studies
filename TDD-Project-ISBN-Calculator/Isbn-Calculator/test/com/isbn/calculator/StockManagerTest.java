package com.isbn.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class StockManagerTest {

    private ExternalISBNDataService dataService;
    private StockManager stockManager;
    private Book book;

    @BeforeEach
    private void init() {
        this.dataService = mock(ExternalISBNDataService.class);
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
}
