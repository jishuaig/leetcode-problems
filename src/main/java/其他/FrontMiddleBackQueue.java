package 其他;

import java.util.ArrayList;
import java.util.List;

class FrontMiddleBackQueue {

    private List<Integer> list;

    public FrontMiddleBackQueue() {
        list = new ArrayList<>();
    }

    public void pushFront(int val) {
        list.add(0, val);
    }

    public void pushMiddle(int val) {
        list.add(list.size() / 2, val);
    }

    public void pushBack(int val) {
        list.add(val);
    }

    public int popFront() {
        if (list.size() == 0) {
            return -1;
        }
        return list.remove(0);
    }

    public int popMiddle() {
        if (list.size() == 0) {
            return -1;
        }
        int middle = (list.size() - 1) / 2;
        return list.remove(middle);
    }

    public int popBack() {
        if (list.size() == 0) {
            return -1;
        }
        return list.remove(list.size() - 1);
    }
}


