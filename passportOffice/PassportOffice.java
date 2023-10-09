package passportOffice;

public class PassportOffice {

    static TokenManager tokenManager;
    static DeskManager deskManager;

    static {
        deskManager = new DeskManager();
        tokenManager = new TokenManager(deskManager);
    }

    public static void main(String[] args) {
        deskManager.addDesk(1);
        deskManager.addDesk(2);
        deskManager.addDesk(3);

        Token t = tokenManager.getToken();
        deskManager.startTokenFlow(t);

        int desknumber = 1;
        Double nextToken = deskManager.getNextTokenForDesk(desknumber);

        while(nextToken != null) {
            System.out.println("Token Number" + nextToken);
            System.out.println("Desk Completed" + desknumber);
            Desk nextDesk = tokenManager.moveTokenToNextDesk(nextToken);
            if(nextDesk == null){
                break;
            }
            desknumber = nextDesk.order;
            deskManager.moveTokenToNextDesk(nextDesk.order, nextToken);
            nextToken = deskManager.getNextTokenForDesk(desknumber);
        }

    }
}
