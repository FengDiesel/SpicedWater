package control;

import model.Game;
import view.GamePage;
import view.HomePage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private HomePage homePage;
    private Game game;
    private GamePage gamePage;

    public Controller(HomePage homePage, Game game){
        this.homePage = homePage;
        this.game = game;
        homeListeners();
    }

    public void homeListeners(){
        homePage.getSubmit().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(!homePage.getTxtUsername().getText().isEmpty()){
                    game.startGame(homePage.getTxtUsername().getText());
                    homePage.dispose();

                    gamePage = game.getGamePage();
                    gameListeners();
                }else{
                    JOptionPane.showMessageDialog(null, "Insert a valid username", "Username error", JOptionPane.ERROR_MESSAGE);
                }
            }

        });
    }

    public void gameListeners(){
        gamePage.getBtn1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (game.getQuestionNumber()){
                    case 0 -> {
                        if(gamePage.getBtn1().getText().equalsIgnoreCase(game.getDrinks()[game.getDrinkNumber()].getStrDrink())){
                            game.setScore(game.getScore()+100);
                        }else game.setLives(game.getLives()-1);
                    }

                    case 1 -> {
                        if(gamePage.getBtn1().getText().equalsIgnoreCase(game.getDrinks()[game.getDrinkNumber()].getStrGlass())){
                            game.setScore(game.getScore()+100);
                        }else game.setLives(game.getLives()-1);
                    }

                    case 2 -> {
                        if(gamePage.getBtn1().getText().equalsIgnoreCase(game.getDrinks()[game.getDrinkNumber()].getStrIngredient1())){
                            game.setScore(game.getScore()+100);
                        }else game.setLives(game.getLives()-1);
                    }
                }

                game.gameLoop();
            }
        });

        gamePage.getBtn2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (game.getQuestionNumber()){
                    case 0 -> {
                        if(gamePage.getBtn2().getText().equalsIgnoreCase(game.getDrinks()[game.getDrinkNumber()].getStrDrink())){
                            game.setScore(game.getScore()+100);
                        }else game.setLives(game.getLives()-1);
                    }

                    case 1 -> {
                        if(gamePage.getBtn2().getText().equalsIgnoreCase(game.getDrinks()[game.getDrinkNumber()].getStrGlass())){
                            game.setScore(game.getScore()+100);
                        }else game.setLives(game.getLives()-1);
                    }

                    case 2 -> {
                        if(gamePage.getBtn2().getText().equalsIgnoreCase(game.getDrinks()[game.getDrinkNumber()].getStrIngredient1())){
                            game.setScore(game.getScore()+100);
                        }else game.setLives(game.getLives()-1);
                    }
                }

                game.gameLoop();
            }
        });

        gamePage.getBtn3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (game.getQuestionNumber()){
                    case 0 -> {
                        if(gamePage.getBtn3().getText().equalsIgnoreCase(game.getDrinks()[game.getDrinkNumber()].getStrDrink())){
                            game.setScore(game.getScore()+100);
                        }else game.setLives(game.getLives()-1);
                    }

                    case 1 -> {
                        if(gamePage.getBtn3().getText().equalsIgnoreCase(game.getDrinks()[game.getDrinkNumber()].getStrGlass())){
                            game.setScore(game.getScore()+100);
                        }else game.setLives(game.getLives()-1);
                    }

                    case 2 -> {
                        if(gamePage.getBtn3().getText().equalsIgnoreCase(game.getDrinks()[game.getDrinkNumber()].getStrIngredient1())){
                            game.setScore(game.getScore()+100);
                        }else game.setLives(game.getLives()-1);
                    }
                }

                game.gameLoop();
            }
        });

        gamePage.getBtn4().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (game.getQuestionNumber()){
                    case 0 -> {
                        if(gamePage.getBtn4().getText().equalsIgnoreCase(game.getDrinks()[game.getDrinkNumber()].getStrDrink())){
                            game.setScore(game.getScore()+100);
                        }else game.setLives(game.getLives()-1);
                    }

                    case 1 -> {
                        if(gamePage.getBtn4().getText().equalsIgnoreCase(game.getDrinks()[game.getDrinkNumber()].getStrGlass())){
                            game.setScore(game.getScore()+100);
                        }else game.setLives(game.getLives()-1);
                    }

                    case 2 -> {
                        if(gamePage.getBtn4().getText().equalsIgnoreCase(game.getDrinks()[game.getDrinkNumber()].getStrIngredient1())){
                            game.setScore(game.getScore()+100);
                        }else game.setLives(game.getLives()-1);
                    }
                }

                game.gameLoop();
            }
        });
    }
}
