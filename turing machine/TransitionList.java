import java.util.*;

public class TransitionList {
    private ArrayList<Transition> list = new ArrayList<>();

    public void addTransition(Transition tr) {
        this.list.add(tr);
    }

    public Transition findTransition(String state, char symbol) {
        for (Transition tmp : list) {
            if (tmp.getStateA().equals(state) && tmp.getReadSymbol() == symbol) {
                return tmp;
            }
        }
        return null; 
    }

    public ArrayList<Transition> getAllTransitions() {
        return new ArrayList<>(list);
    }
}