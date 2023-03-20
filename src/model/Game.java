package model;

import view.GamePage;
import org.json.JSONObject;
import org.json.XML;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Random;

public class Game {
    private GamePage gamePage;

    private String[] questions = {"Name of the drink?", "Type of glass used?", "Main ingredient?"};
    private int questionNumber = 0;
    private int drinkNumber = 0;
    private int lives = 5;
    private int score = 0;

    private boolean end = false;

    private Drink[] drinks = new Drink[4];

    public Game(){ }

    public void startGame(String username) {
        gamePage = new GamePage(this);

        System.out.println("[+] Game started...");
        System.out.println("[+] Username: " + username);

        gameLoop();
    }

    public void gameLoop(){
        if(lives > 0){
            newTurn();
            gamePage.repaint();
        }else{
            gamePage.finishGame();
        }

    }

    private void newTurn() {
        questionNumber = getRandomInt(3);
        drinkNumber = getRandomInt(4);
        makeRequests();
    }


    private void makeRequests() {
        try{
            HttpRequest getRequest;
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> getResponse;
            JSONObject json;
            String xml;
            JAXBContext jaxbContext = JAXBContext.newInstance(Drink.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            for (int i=0; i<4; i++){
                getRequest = HttpRequest.newBuilder()
                        .uri(new URI("https://www.thecocktaildb.com/api/json/v1/1/random.php"))
                        .build();

                getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

                //System.out.println(getResponse.body());

                json = new JSONObject(getResponse.body());
                xml = XML.toString(json);

                //System.out.println(xml);

                drinks[i] = (Drink) unmarshaller.unmarshal(new StringReader(xml));

                System.out.println(drinks[i].getStrDrink());

            }

            for(int i=0; i<4; i++){
                for(int j=i+1; j<4; j++){
                    if(drinks[i].getStrDrink().equalsIgnoreCase(drinks[j].getStrDrink())){
                        getRequest = HttpRequest.newBuilder()
                                .uri(new URI("https://www.thecocktaildb.com/api/json/v1/1/random.php"))
                                .build();

                        getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

                        //System.out.println(getResponse.body());

                        json = new JSONObject(getResponse.body());
                        xml = XML.toString(json);

                        //System.out.println(xml);

                        drinks[j] = (Drink) unmarshaller.unmarshal(new StringReader(xml));

                        System.out.println(drinks[j].getStrDrink());
                    }
                }
            }

        }catch(URISyntaxException | InterruptedException | IOException | JAXBException e){
            e.printStackTrace();
        }

    }

    public int getRandomInt(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }

    public GamePage getGamePage() {
        return gamePage;
    }

    public Drink[] getDrinks() {
        return drinks;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public int getDrinkNumber() {
        return drinkNumber;
    }

    public String[] getQuestions() {
        return questions;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
}
