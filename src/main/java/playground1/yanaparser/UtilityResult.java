package playground1.yanaparser;

import java.util.List;

/**
 * Need this for Axis
 */
public final class UtilityResult {
    private String[] axisValues;
    private List<String[]> valuesList;

    public UtilityResult(String[] axisValues, List<String[]> valuesList) {
        this.axisValues = axisValues;
        this.valuesList = valuesList;
    }

    public String[] getAxisValues() {
        return axisValues;
    }

    public void setAxisValues(String[] axisValues) {
        this.axisValues = axisValues;
    }

    public List<String[]> getValuesList() {
        return valuesList;
    }

    public void setValuesList(List<String[]> valuesList) {
        this.valuesList = valuesList;
    }
}
