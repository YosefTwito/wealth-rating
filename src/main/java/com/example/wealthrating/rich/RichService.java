package com.example.wealthrating.rich;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class RichService {

    private final RichRepository richRepository;

    @Autowired
    public RichService(RichRepository richRepository) {
        this.richRepository = richRepository;
    }

    public List<Rich> getRiches() {
        return richRepository.findAll();
    }

    public Rich getRichById(Long id){
        if (richRepository.findByIdentity(id).isEmpty()){
            System.out.println("No rich people with Id: " + id);
        }
        return richRepository.findByIdentity(id).get();
    }

    public String postRich(Person p){

        Long thresh = 15000000L; // From api
        Long evaluateResponse = 500000L; // From api

        Long cash = p.getFinancInfo().getCash();
        int numOfAssets = p.getFinancInfo().getNumberOfAssets();

        try {
            thresh = sendGetThresh();
            evaluateResponse = sendGetEvaluate(p.getPersonInfo().getCity());
        }catch (Exception e){}

        Long fortune = cash + ((long) numOfAssets * evaluateResponse);

//        System.out.println("Fortune: " + fortune + ",  thresh: " + thresh);

        if (fortune > thresh) {
            Rich rich = new Rich(p.getId(), p.getPersonInfo().getFirstName(), p.getPersonInfo().getLastName(), fortune);
            richRepository.save(rich);
            return ("Rich: " + rich.getFirstName() + " " + rich.getLastName() + " is Rich");
        }
        else{
            return ("Not-rich: " + p.getPersonInfo().getFirstName() + " " + p.getPersonInfo().getLastName() + " is not Rich");
        }
    }

    private Long sendGetThresh() throws Exception {

        HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8080/central-bank/wealth-threshold"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return Long.parseLong(response.body());
    }

    private Long sendGetEvaluate(String city) throws Exception {

        HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8080/central-bank/regional-info/evaluate?city="+ city + ""))
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return Long.parseLong(response.body());
    }

}
