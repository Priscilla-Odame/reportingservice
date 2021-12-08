package reportingservice;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import reportingservice.controllers.ReportingController;
import reportingservice.entities.Order;
import reportingservice.enums.Side;
import reportingservice.enums.Status;
import reportingservice.repositories.OrderRepository;
import reportingservice.services.ReportingService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReportingController.class)
public class ReportingControllerTest {
    @Autowired
    MockMvc mockMvc;

//    @Autowired
//    ObjectMapper objectMapper;

    @MockBean
    ReportingService reportingService ;

    Order order1 = new Order("12345", "MSFT",5,15.9, Side.BUY, Status.PENDING);
    Order order2 = new Order("12346", "NFLX",8,14.59, Side.SELL, Status.PENDING);
    Order order3 = new Order("12347", "AAPL",29,200.0, Side.BUY, Status.PENDING);
    Order order4 = new Order("12348", "MSFT",4,13.5, Side.SELL, Status.PENDING);

    @Test
    public void getAllOrders() throws Exception{
        List<Order> orders = new ArrayList<>(Arrays.asList(order1,order2,order3,order4));
        Mockito.when(reportingService.getAllOrders()).thenReturn(orders);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/report")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[2].product", is("AAPL")));
    }

    @Test
    public void getOrderById() throws Exception {
        Mockito.when(reportingService.getReportById(order1.getId()))
                .thenReturn(java.util.Optional.of(order1));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/report/12345")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.quantity", is(5)));
    }
}
