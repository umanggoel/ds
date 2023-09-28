package design.splitwise.model.strategy;

import design.splitwise.model.Expense;
import design.splitwise.model.users.User;

import java.util.List;

public interface ISplitStrategy {
    public List<Expense> getExpensesFortheUsers(User fromUser, List<User> toUserList, Integer amount);
    public String getStrategyName();
}
