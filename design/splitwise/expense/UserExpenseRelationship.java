package design.splitwise.expense;

import design.splitwise.model.Expense;
import design.splitwise.model.users.User;

import java.util.ArrayList;
import java.util.List;

public class UserExpenseRelationship {
    User fromUser;
    private List<Expense> debitExpenses;
    private List<Expense> creditExpenses;

    public UserExpenseRelationship(User user) {
        this.fromUser = user;
        this.debitExpenses = new ArrayList<>();
        this.creditExpenses = new ArrayList<>();
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

   public void addDebitExpense(Expense expense){
        debitExpenses.add(expense);
   }

   public void addCreditExpense(Expense expense){
        creditExpenses.add(expense);
   }

    public List<Expense> getDebitExpenses() {
        return debitExpenses;
    }

    public List<Expense> getCreditExpenses() {
        return creditExpenses;
    }
}
