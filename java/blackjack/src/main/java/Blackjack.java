public class Blackjack {

    public int parseCard(String card) {

        switch (card) {
            case "two":
                return 2;
            case "three":
                return 3;
            case "four":
                return 4;
            case "five":
                return 5;
            case "six":
                return 6;
            case "seven":
                return 7;
            case "eight":
                return 8;
            case "nine":
                return 9;
            case "ten":
                return 10;
            case "jack":
                return 10;
            case "queen":
                return 10;
            case "king":
                return 10;
            case "ace":
                return 11;
            default:
                return 0;
        }
    }

    public boolean isBlackjack(String card1, String card2) {

        int card1Value = parseCard(card1);
        int card2Value = parseCard(card2);

        int sumOfCards = card1Value + card2Value;
        return sumOfCards == 21;
    }

    public String largeHand(boolean isBlackjack, int dealerScore) {

        boolean automaticallyWin = isBlackjack && dealerScore < 10;

            if (automaticallyWin) {
                return "W";
            } else if (isBlackjack){
                return "S";
            } else {
                return "P";
            }
    }

    public String smallHand(int handScore, int dealerScore) {

        boolean split = handScore == 22;
        boolean stand = handScore >= 17;
        boolean hit = handScore <= 11;

        if (split) {
            return "P";
        } else {
            if (handScore < 21) {
                if (stand) {
                    return "S";
                } else if (hit || dealerScore >= 7) {
                    return "H";
                } else {
                    return "S";
                }
            }
        }
        return null;
    }

    // FirstTurn returns the semi-optimal decision for the first turn, given the cards of the player and the dealer.
    // This function is already implemented and does not need to be edited. It pulls the other functions together in a
    // complete decision tree for the first turn.
    public String firstTurn(String card1, String card2, String dealerCard) {
        int handScore = parseCard(card1) + parseCard(card2);
        int dealerScore = parseCard(dealerCard);

        if (20 < handScore) {
            return largeHand(isBlackjack(card1, card2), dealerScore);
        } else {
            return smallHand(handScore, dealerScore);
        }
    }
}
