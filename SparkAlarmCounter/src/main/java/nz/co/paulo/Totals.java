package nz.co.paulo;

import spark.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Martin Paulo on 1/07/2014.
 * An implementation of the Presentation Model pattern (http://martinfowler.com/eaaDev/PresentationModel.html).
 * It's largely used to transfer values into the Mustache template.
 */
public class Totals {

    private int rowCount;
    List<Row> rows;

    static class Row {
        final String alert;
        final String value;
        final String cssClass;

        Row(String alert, String value, String cssClass) {
            this.alert = alert;
            this.value = value;
            this.cssClass = cssClass;
        }
    }

    public ModelAndView getTotals(Map<String, Integer> alarmTotals) {
        rowCount = 0;
        rows = new ArrayList<>();
        alarmTotals.forEach((key, value) -> rows.add(new Row(key, value.toString(), getCssClass(rowCount++))));
        return new ModelAndView(this, "totals.mustache");
    }

    private String getCssClass(int rowCount) {
        return ((rowCount % 2 != 0) ? "even" : "odd");
    }

}
