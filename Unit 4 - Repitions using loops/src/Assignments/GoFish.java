package Assignments;

import java.util.Scanner;

public class GoFish {
    static Scanner in = new Scanner(System.in);

    private static final int NUM_SUITS = 4;
    private static final int RESET_CARDS = -2;

    private static final int NUM_VALUES = 13;

    private static final int REQUEST_CARDS = 1;
    private static final int CHECK_HAND = 2;
    private static final int CHECK_SCORE = 3;

    private static final int PLAYER = 1;
    private static final int COMPUTER1 = 2;
    private static final int COMPUTER2 = 3;
    private static final int COMPUTER3 = 4;

    static boolean gameEnded = false;

    static String playerHand = newHand(), computerHand1 = newHand(), computerHand2 = newHand(), computerHand3 = newHand();
    static int playerScore = 0, comScore1 = 0, comScore2 = 0, comScore3 = 0;

    public static void main(String[] args) {
        gameEnded = false;
        
        System.out.println("Welcome to Go Fish!!!\n");
        System.out.println("Dealing Cards...\n");
        displayHand(PLAYER);

        removePairs(playerHand, PLAYER);
        removePairs(computerHand1, COMPUTER1);
        removePairs(computerHand2, COMPUTER2);
        removePairs(computerHand3, COMPUTER3);

        while(!gameEnded) {
            playerTurn();
            computerTurn(COMPUTER1);
            computerTurn(COMPUTER2);
            computerTurn(COMPUTER3);                
        }
    }

    private static void computerTurn(int n) {
        System.out.println("Computer " + (n-1) + "'s turn");
        if (comScore1 == 10) endGame(COMPUTER1);
        if (comScore2 == 10) endGame(COMPUTER2);
        if (comScore3 == 10) endGame(COMPUTER3);
        if (!gameEnded) {
            int playerTargeted = 0;
            while(true) {
                playerTargeted = (int) (Math.random()*4) + 1;
                if(playerTargeted != n)
                    break;
            } 
            checkHand(playerTargeted, n);
            noCardsLeft();
        }
        
    }

    private static void playerTurn() {
        displayHand(PLAYER);
        displayHand(COMPUTER1);
        displayHand(COMPUTER2);
        displayHand(COMPUTER3);
        
        while(true) {
            System.out.println("\nWhat would you like to do?");

            int action = chooseAction();
            int choice = choosePlayer(action);

            if(action == REQUEST_CARDS) {
                checkHand(choice, PLAYER);
                noCardsLeft();

            if(playerScore == 10)
                    endGame(PLAYER);
            if(playerHand.length() == 0) {
                System.out.println("Drawing 5 new cards...");
                playerHand = newHand();
                removePairs(playerHand, PLAYER);
            }
                    
            break;
            } else if(action == CHECK_HAND)
                displayHand(choice);
            else if(action == CHECK_SCORE) 
                displayScore(choice);
                
            System.out.println();
            }
        }


    private static void endGame(int n) {
        String winner = "";

        if (playerScore == 10)
            winner = "Player";
        if (comScore1 == 10)
            winner = "Computer1";
        if (comScore2 == 10)
            winner = "Computer2";
        if (comScore3 == 10)
            winner = "Computer3";

        System.out.println(winner + " won the game. Congratulations!");

        if (playAgain()) {
            playerHand = newHand(); computerHand1 = newHand(); computerHand2 = newHand(); computerHand3 = newHand();
            playerScore = 0; comScore1 = 0; comScore2 = 0; comScore3 = 0;

            main(null);
        } 
        else gameEnded = true;
        
    }

    private static boolean playAgain() {
        while (true){
            System.out.println("Would you want to play again? (Yes/No)");
            String ans = in.nextLine().toLowerCase();
            if (ans.equals("yes"))
                return true;
            else return false;
        }
    }

    private static void noCardsLeft() {
        if (playerHand.length() == 0 || computerHand1.length() == 0 || computerHand2.length() == 0 || computerHand3.length() == 0) {
            if (playerHand.length() == 0) {
                System.out.println("You have 0 cards left, drawing 5 new cards");
                playerHand = newHand();
                removePairs(playerHand, CHECK_HAND);          
            } if (computerHand1.length() == 0) {
                System.out.println("Computer1 has 0 cards left, drawing 5 new cards");
                playerHand = newHand();
                removePairs(computerHand1, CHECK_HAND);
            } if (computerHand2.length() == 0) {
                System.out.println("Computer2 has 0 cards left, drawing 5 new cards");
                playerHand = newHand();
                removePairs(computerHand2, CHECK_HAND);
            } if (computerHand3.length() == 0) {
                System.out.println("Computer3 has 0 cards left, drawing 5 new cards");
                playerHand = newHand();
                removePairs(computerHand3, CHECK_HAND);
            }
        }
    }

    private static void checkHand(int playerTargeted, int requester) {
        String card = "";
        if(requester == PLAYER)  card = playerRequestCards();
        else card = computerRequestCards(requester);

        String hand = card + "D";
        if(playerTargeted == PLAYER) hand += playerHand;
        if(playerTargeted == COMPUTER1) hand += computerHand1;
        if(playerTargeted == COMPUTER2) hand += computerHand2;
        if(playerTargeted == COMPUTER3) hand += computerHand3;

        boolean hasRequested = false;
        for (int i = 0; i < hand.length() - 1; i+=2) {
            String c = hand.charAt(i) + "";
            String x = hand.substring(hand.indexOf(c) + 2);
            if(x.contains(c)) {
                hasRequested = true;
                hand = hand.substring(0, i) + x.substring(0, x.indexOf(c)) + x.substring(x.indexOf(c) + 2);
                break;
            }
        }

        if(!hasRequested)
            hand = hand.substring(2);

        if(playerTargeted == PLAYER) playerHand = hand;
        if(playerTargeted == COMPUTER1) computerHand1 = hand;
        if(playerTargeted == COMPUTER2) computerHand2 = hand;
        if(playerTargeted == COMPUTER3) computerHand3 = hand;

        if(hasRequested) {
            System.out.println("Match Found!\n");

            if(requester == PLAYER) removePairs(playerHand + card + "D", PLAYER);
            if(requester == COMPUTER1) removePairs(computerHand1 + card + "D", COMPUTER1);
            if(requester == COMPUTER2) removePairs(computerHand2 + card + "D", COMPUTER2);
            if(requester == COMPUTER3) removePairs(computerHand3 + card + "D", COMPUTER3);
        } else {
                System.out.println("Go Fish! Drawing a card from the pile.");

                if(requester == PLAYER) {
                playerHand += getCard();
                removePairs(playerHand, PLAYER);
                } if(requester == COMPUTER1) {
                computerHand1 += getCard();
                removePairs(computerHand1, COMPUTER1);
                } if(requester == COMPUTER2) {
                computerHand2 += getCard();
                removePairs(computerHand2, COMPUTER2);
                } if(requester == COMPUTER3) {
                computerHand3 += getCard();
                removePairs(computerHand3, COMPUTER3);
                }
        }
    }

    private static String playerRequestCards() { 
        while(true) {
            System.out.println("\nWhat card would you like to request?");
                
            String x = "";
                for(int i = 0; i < playerHand.length() - 1; i += 2) {
                if(i != 0)
                    x += ", ";
                x += playerHand.charAt(i);
                }

                System.out.print(x + ": ");

                String card = in.nextLine();
                if(playerHand.indexOf(card) == -1)
                System.out.println("Please enter a valid option.\n");
                else return card;
        }
    }

    private static String computerRequestCards(int n) {
        String hand = "";
        if(n == COMPUTER1)
            hand = computerHand1;
        if(n == COMPUTER2)
            hand = computerHand2;
        if(n == COMPUTER3)
            hand = computerHand3;

        int random = (int) (Math.random() * hand.length());
        if(random % 2 != 0)
            random--;
        return hand.charAt(random) + "";
    }


    private static int choosePlayer(int action) {
        String asker = "";
        if(action == REQUEST_CARDS)
            asker = "Which player would you like to ask for cards?";
        if(action == CHECK_HAND)
            asker = "Which player's hand would you like to check?";
        if(action == CHECK_SCORE)
                asker = "Which player's score would you like to check?";

            while(true) {
                System.out.print("\n" + asker + "\nPlayer (1), Computer1 (2), Computer2 (3), Computer3 (4): ");
                try {
                    int n = Integer.parseInt(in.nextLine());

                    if(action == REQUEST_CARDS && n == PLAYER)
                        System.out.println("You cannot ask yourself for cards!\n");
                    else if(n > 4 || n < 1)
                        System.out.println("Please enter a valid option.\n");
                    else
                        return n;
                } catch(NumberFormatException e) {
                    System.out.println("Please enter a valid option.\n");
                }
            }
        }

        private static int chooseAction() {
            while(true) {
                System.out.print("Request Cards (1), Check Hands (2), Check Scores (3): ");
                try {
                    int action = Integer.parseInt(in.nextLine());

                    if(action > 3 || action < 1) 
                        System.out.println("Please enter a valid option.\n");
                    else
                        return action;
                } catch(NumberFormatException e) {
                    System.out.println("Please enter a valid option.\n");
                }
            }
        }

        private static void removePairs(String hand, int n) {
            int count = 0;
            String found = "No pairs found.";
            for (int i = 0; i < hand.length() - 1; i+=2) {
                String c = hand.charAt(i) + "";
                String x = hand.substring(hand.indexOf(c) + 2);
                if(x.contains(c)) {
                    count++;
                    found = count + " pair(s) found!";
                    hand = hand.substring(0, i) + x.substring(0, x.indexOf(c)) + x.substring(x.indexOf(c) + 2);
                    i = RESET_CARDS;
                }
            } 
            
            String name = "";
            if(n == PLAYER) {
                playerScore += count;
                playerHand = hand;
                name = "Player";
            } else if(n == COMPUTER1) {
                comScore1 += count;
                computerHand1 = hand;
                name = "Computer1";
            } else if(n == COMPUTER2) {
                comScore2 += count;
                computerHand2 = hand;
                name = "Computer2";
            } else if(n == COMPUTER3) {
                comScore3 += count;
                computerHand3 = hand;
                name = "Computer3";
            }

            System.out.println("Looking for pair(s) in " + name + "'s hand... " + found + "\n");
        }

        public static void displayHand(int n) {              
            if(n == PLAYER) {
                String deck = "";
                for(int i = 0; i < playerHand.length(); i++) {
                    if(i % 2 == 0 && i != 0)
                        deck += " ";
                    deck += playerHand.charAt(i) + "";
                }
            String newdeck = deck.replace("X", "10");

                System.out.println("Player Hand: " + newdeck + "\n");
            } else if(n == COMPUTER1) {
                System.out.println("Computer1 Cards Left: " + computerHand1.length() / 2);
            } else if(n == COMPUTER2) {
                System.out.println("Computer2 Cards Left: " + computerHand2.length() / 2);
            } else if(n == COMPUTER3) {
                System.out.println("Computer3 Cards Left: " + computerHand3.length() / 2);
            }
        }

        private static void displayScore(int n) {
            if(n == PLAYER)
                System.out.println("Player Score: " + playerScore);
            else if(n == COMPUTER1)
                System.out.println("Computer1 Score: " + comScore1);
            else if(n == COMPUTER2)
                System.out.println("Computer2 Score: " + comScore2);
            else if(n == COMPUTER3)
                System.out.println("Computer3  Score: " + comScore3);
        }

        public static String newHand() {
            return getCard() + getCard() + getCard() + getCard() + getCard();
        }

        private static String getCard() {
            return getValue() + getSuit();
        }

        private static String getSuit() {
            int iSuit = (int) Math.round(Math.random() * NUM_SUITS + 1);
            if (iSuit == 1)
                return "H";
            if (iSuit == 2)
                return "S";
            if (iSuit == 3)
                return "C";
            return "D";
        }

        private static String getValue() {
            int card = (int) (Math.random() * NUM_VALUES + 1);
            if(card == 1)
                return "A";
            else if (card == 10)
                return "X";
            else if (card == 11)
                return "J";
            else if (card == 12) 
                return "Q";
            else if (card == 13)
                return "K";
            return "" + card;
        }
    }