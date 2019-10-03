/*package com.kpn.nl.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.kpn.nl.model.Movie;
import com.kpn.nl.model.MovieDTO;
import com.kpn.nl.model.MoviesDTO;
import com.kpn.nl.service.impl.MovieServiceimpl;

@RunWith(SpringRunner.class)
public class CustomerControllerUnitTest {

	private MockMvc mockMvc;

	@Mock
	private MovieServiceimpl movieServiceimpl;
	
	@Mock
	private Movie movie;

	@InjectMocks
	private CustomerController customerController;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
	}

	@Test
	public void ExceptionGenerteWithInvalidID() throws Exception {
		StockResponse stockResponse = new StockResponse(1, "testStcok", null);
		List<StockResponse> stockList = new ArrayList<>();
		stockList.add(stockResponse);
		when(stockOperationsServiceImpl.findAllStocks()).thenReturn(stockList);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/stocks").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.listOfStock", hasSize(1))).andExpect(jsonPath("$.listOfStock[0].id", is(1)))
				.andExpect(jsonPath("$.listOfStock[0].name", is("testStcok")));
	}

	@Test
	public void testGetMovieListByProvidingUserId() throws Exception {
		//StockResponse stockResponse = new StockResponse(1, "testStock", new Price());
		
		MoviesDTO movies = new MoviesDTO();
		List<Movie> interests = new ArrayList<>();
		movie.setActor(actors);
		interests.add(movie.getId());
		interests.forEach(movie -> {
			movies.getMovieCategory().add(new MovieDTO("testtitle", "testimdb"));
		});
		
		when(movieServiceimpl.findInterests(1003L)).thenReturn(movies);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/stocks/1").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.name", is("testStock")));
	}

}
*/