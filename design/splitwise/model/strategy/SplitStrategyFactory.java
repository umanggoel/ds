package design.splitwise.model.strategy;

import design.splitwise.exception.NOSuchStrategyException;

import java.util.ArrayList;
import java.util.List;

public class SplitStrategyFactory {
    List<ISplitStrategy> splitStrategyList ;

    public SplitStrategyFactory(){
        splitStrategyList = new ArrayList<>();
        splitStrategyList.add(new SplitStrategy());
    }

    public ISplitStrategy getSplitStrategy(String splitStrategy) throws NOSuchStrategyException {
        for(ISplitStrategy strategy : splitStrategyList){
            if(strategy.getStrategyName().equals(splitStrategy)){
                return strategy;
            }
        }
        throw new NOSuchStrategyException();
    }
}
