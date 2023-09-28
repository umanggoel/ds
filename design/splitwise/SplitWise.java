package design.splitwise;

import design.splitwise.exception.DuplicateUserException;
import design.splitwise.exception.NOSuchStrategyException;
import design.splitwise.expense.UserExpenseManager;
import design.splitwise.model.Expense;
import design.splitwise.model.users.User;
import design.splitwise.user.UserManager;

import java.util.ArrayList;
import java.util.List;

public class SplitWise {
    // https://workat.tech/machine-coding/editorial/how-to-design-splitwise-machine-coding-ayvnfo1tfst6
    public static void main(String[] args) throws DuplicateUserException, NOSuchStrategyException {
        User user1 = new User(1, "A", "a@splitwise.com" );
        User user2 = new User(2, "B", "b@splitwise.com" );
        User user3 = new User(3, "C", "c@splitwise.com" );

        UserManager userManager = new UserManager();
        userManager.addUser(user1);
        userManager.addUser(user2);
        userManager.addUser(user3);

        UserExpenseManager userExpenseManager = new UserExpenseManager();
        List<User> userList = new ArrayList<>();
        userList.add(user2); userList.add(user3);
        userExpenseManager.addUserExpsenses(user1, userList, 30, "EQUAL"); // U1 - U2(10), U3(10)

        List<User> userList2 = new ArrayList<>();
        userList2.add(user1);userList2.add(user3);

        userExpenseManager.addUserExpsenses(user2,userList2, 60, "EQUAL"); // U2 - U1(20), U3(20)

        List<Expense> expenseList = userExpenseManager.getAllBalances(user1);
        for(Expense expense : expenseList){
            System.out.println("ExpenseType : "+ expense.getExpenseType() + " to User : " + expense.getToUser().getId() + " - Amount "+ expense.getAmount());
        }
    }
}
