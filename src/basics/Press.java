package basics;

import basics.model.Olive;

import java.util.List;

public interface Press {
    public int getOil(List<Olive> olives);
    public void setOil(int oil);
}

