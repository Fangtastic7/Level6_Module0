package _04_jeopardy_api;

import _04_jeopardy_api.data_transfer_objects.Clue;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import _01_intro_to_APIs.data_transfer_objects.Result;
import _02_cat_facts_API.data_transfer_objects.CatWrapper;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
Now lets use a Jeopardy API to make a (modified) game.
To simplify things a little bit, we will just ask the user one question from each available point category
 */

public class JeopardyApi {

    private final WebClient webClient;

    private static final String baseUrl = "http://jservice.io/api/clues";

    public JeopardyApi() {
        webClient = WebClient
                .builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public Clue getClue(int value) {
    	//1  Use the WebClient code from the previous exercises to make the request:
        //Note:
        //The base URL has already been provided, but we we need to take the "value" parameter passed into
        //this method and supply it as a query parameter with the name of "value".  This allows us to retrieve a question
        //with the specified point value.
        //
        //Make sure to save the response as type Clue[].class in the bodyToMono() method call
    	 Mono<Clue[]> cheetahMono = webClient
                 .get()
                 .uri(uriBuilder -> uriBuilder
                         .queryParam("value")
                         .build())
                 .retrieve()
                 .bodyToMono(Clue[].class);
    	 
    	 Clue[] response = cheetahMono.block();
    	 
        //2
        //Get a random number less than the size of the Clue array
    	  int number = new Random().nextInt(response.length);
        //3
        //return the clue at the random index you just created
    	 return response[number];
    	
    	
    	
    	
        //create the request URL
        //can be found in the documentation: http://jservice.io/
    	 
    	 
        //1
        //uncomment the next line to see the actual JSON response -
        // this is what was inputted into jsonschema2pojo.com
        

        //2
        //Use http://www.jsonschema2pojo.org/ to generate your POJOs
        //and place them in the cat_facts_API.pojo package
        //select Target Language = java, Source Type = JSON, Annotation Style = Gson


        //3
        //Get a random number less than the size of the jsonArray
     
        //4
        //return the clue at the random index you just created
       
      
    }
}
