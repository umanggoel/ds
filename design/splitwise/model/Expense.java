package design.splitwise.model;

import design.splitwise.common.ExpenseType;
import design.splitwise.model.users.User;

public class Expense {
    private User toUser;
    private ExpenseType expenseType;
    private int amount;

    public Expense(User user, ExpenseType expenseType, int amount) {
        this.toUser = user;
        this.expenseType = expenseType;
        this.amount = amount;
    }

    public User getToUser() {
        return toUser;
    }

    public int getAmount() {
        return amount;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }
}
