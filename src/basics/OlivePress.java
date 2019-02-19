package basics;

import basics.model.Olive;
import java.util.List;

public class OlivePress implements Press {

    int currentOil;
    public int getOil(List<Olive> olives) {

        int totalOil = 0;
        for (Olive o : olives) {
            System.out.println(o.getName());
            totalOil += o.crush();
        }

        return totalOil;
    }

    @Override
    public void setOil(int oil) {
        currentOil = oil;
    }


}
