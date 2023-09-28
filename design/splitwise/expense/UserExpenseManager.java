package design.splitwise.expense;

import design.splitwise.common.ExpenseType;
import design.splitwise.exception.NOSuchStrategyException;
import design.splitwise.model.Expense;
import design.splitwise.model.strategy.ISplitStrategy;
import design.splitwise.model.strategy.SplitStrategyFactory;
import design.splitwise.model.users.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserExpenseManager {
    // User - (user2, amt debt/credit)
    Map<User, UserExpenseRelationship> userPriceRelationMap;
    SplitStrategyFactory splitStrategyFactory;

    public UserExpenseManager() {
        this.userPriceRelationMap = new HashMap<>();
        this.splitStrategyFactory = new SplitStrategyFactory();
    }

    public void addUserExpsenses(User user, List<User> userList, Integer amount, String splitStrategy) throws NOSuchStrategyException {
        if(!userPriceRelationMap.containsKey(user)){
            UserExpenseRelationship priceRelation = userPriceRelationMap.get(user);
            ISplitStrategy strategy = splitStrategyFactory.getSplitStrategy(splitStrategy);
            List<Expense> expenseList = strategy.getExpensesFortheUsers(user, userList, amount);
            UserExpenseRelationship userExpenseRelationship = new UserExpenseRelationship(user);
            for(Expense expense : expenseList){
                if(expense.getExpenseType().equals(ExpenseType.DEBIT)){
                    userExpenseRelationship.addDebitExpense(expense);
                    Expense expense1 = new Expense(expense.getToUser(), ExpenseType.CREDIT, expense.getAmount());
                    // adding as credit to another person
                   // userPriceRelationMap.get(expense.getToUser()).addCreditExpense(expense1);
                } else if (expense.getExpenseType().equals(ExpenseType.CREDIT)){
                    userExpenseRelationship.addCreditExpense(expense);
                    //Expense expense1 = new Expense(expense.getToUser(), ExpenseType.DEBIT, expense.getAmount());
                    //userPriceRelationMap.get(expense.getToUser()).addCreditExpense(expense1);
                }
            }
            userPriceRelationMap.put(user,userExpenseRelationship);
            System.out.println("Added Prcing details : "+ user.getId());
        }
    }

    public List<Expense> getAllBalances(User user){
        List<Expense> allExpenses = new ArrayList<>();
        List<Expense> debitList = userPriceRelationMap.get(user).getDebitExpenses();
        List<Expense> creditList = userPriceRelationMap.get(user).getCreditExpenses();

        allExpenses.addAll(debitList);
        allExpenses.addAll(creditList);
        return allExpenses;
    }

}
