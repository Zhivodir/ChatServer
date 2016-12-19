package ua.kiev.prog;

import ua.kiev.prog.model.Message;

import java.util.ArrayList;
import java.util.List;

public class JsonMessages {
    private final List<Message> list;

    public JsonMessages(List<Message> sourceList, int fromIndex, String forLogin) {
        this.list = new ArrayList<>();
        for (int i = fromIndex; i < sourceList.size(); i++) {
            if(forLogin.equals(sourceList.get(i).getTo()) || sourceList.get(i).getTo() == null || forLogin.equals(sourceList.get(i).getFrom())) {
                list.add(sourceList.get(i));
            }
        }
    }
}
