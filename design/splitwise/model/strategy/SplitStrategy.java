package design.splitwise.model.strategy;

import design.splitwise.common.ExpenseType;
import design.splitwise.model.Expense;
import design.splitwise.model.users.User;

import java.util.ArrayList;
import java.util.List;

public class SplitStrategy implements ISplitStrategy {

    @Override
    public List<Expense> getExpensesFortheUsers(User fromUser, List<User> toUserList, Integer amount) {
        // U1 - U2,U3,U4
        List<Expense> expenseList = new ArrayList<>();

        Integer splitedVal =  amount/(toUserList.size()+1);
        for(User toUsers : toUserList){
            Expense e = new Expense(toUsers, ExpenseType.DEBIT, splitedVal);
            expenseList.add(e);
        }
        return expenseList;
    }

    @Override
    public String getStrategyName() {
        return "EQUAL";
    }


}
