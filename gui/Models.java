package gui2;

import java.util.ArrayList;

public class Models implements Observeable {

    private ArrayList<Observe> observers = new ArrayList<>();
    private String[] str = new String[2];
    private double exchange_rub_dol;

    public void setState(FieldType f, String s) {
        exchange_rub_dol = Course.getCourse();
        if ("".equals(s)) {
            str[0] = "";
            str[1] = "";
        } else {
            int num;
            switch (f) {
                case RUB: {
                    num = (int) Math.round(Double.parseDouble(s) / exchange_rub_dol * 100);
                    str[0] = s;
                    str[1] = Double.toString((double) num / 100);
                    break;
                }
                case DOL: {
                    num = (int) Math.round(Double.parseDouble(s) * exchange_rub_dol * 100);
                    str[0] = Double.toString((double) num / 100);
                    str[1] = s;
                    break;
                }
            }
            notifyObservers();
        }
       
    }
    public String getRub()
    {
        return str[0];
    }
    public String getDol()
    {
        return str[1];
    }
    public void setEx(int i)
    {
        exchange_rub_dol = i;
    }

    @Override
    public void registerObserver(Observe o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observe o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observe observer : observers)
        {
            observer.update(this);
        }
    }
}
