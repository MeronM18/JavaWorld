package hellofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Button convertButton;
    @FXML 
    private ChoiceBox<String> firstUnit;
    private final String[] units = {"meters", "kilometers", "feet", "yards", "miles", "kilograms", "pounds", "grams"};
    @FXML 
    private TextField unitValue;
    @FXML
    private ChoiceBox<String> finalUnit;
    @FXML
    private Label conversionLabel; 


    public void initialize() {
        firstUnit.getItems().addAll(units);
        finalUnit.getItems().addAll(units);
    }

    public void convertButtonOnAction(ActionEvent e) {
        // Get the selected units from the choice boxes
        String fromUnit = firstUnit.getValue();
        String toUnit = finalUnit.getValue();
    
        // Parse the value from the TextField
        double value = Double.parseDouble(unitValue.getText());
    
        // Perform the conversion
        double result = convert(value, fromUnit, toUnit);

        String formattedResult = String.format("%.2f", result);
    
        // Update the conversionLabel with the result
        conversionLabel.setText(value + " " + fromUnit + " = " + formattedResult + " " + toUnit);
    }
    
    public double convert(double value, String fromUnit, String toUnit) {
        switch (fromUnit.toLowerCase()) {
            case "meters":
                switch (toUnit.toLowerCase()) {
                    case "kilometers":
                        return value / 1000;
                    case "feet":
                        return value * 3.28084;
                    case "yards":
                        return value * 1.09361;
                    case "miles":
                        return value * 0.000621371;
                    default:
                        break;
                }
                break;
            case "kilograms":
                switch (toUnit.toLowerCase()) {
                    case "pounds":
                        return value * 2.20462;
                    case "grams":
                        return value * 1000;
                    default:
                        break;
                }
                break;
            case "feet":
                switch (toUnit.toLowerCase()) {
                    case "meters":
                        return value / 3.28084;
                    case "yards":
                        return value / 3;
                    case "miles":
                        return value / 5280;
                    case "kilometers":
                        return value / 3280.84;
                    default:
                        break;
                }
                break;
            case "yards":
                switch (toUnit.toLowerCase()) {
                    case "meters":
                        return value / 1.09361;
                    case "feet":
                        return value * 3;
                    case "miles":
                        return value / 1760;
                    default:
                        break;
                }
                break;
            case "miles":
                switch (toUnit.toLowerCase()) {
                    case "meters":
                        return value / 0.000621371;
                    case "feet":
                        return value * 5280;
                    case "yards":
                        return value * 1760;
                    default:
                        break;
                }
                break;
            case "kilometers":
                switch (toUnit.toLowerCase()) {
                    case "meters":
                        return value * 1000;
                    case "feet":
                        return value * 3280.84;
                    case "yards":
                        return value * 1093.61;
                    case "miles":
                        return value * 0.621371;
                    default:
                        break;
                }
                break;
            case "pounds":
                switch (toUnit.toLowerCase()) {
                    case "kilograms":
                        return value / 2.20462;
                    case "grams":
                        return value * 453.592;
                    default:
                        break;
                }
                break;
            case "grams":
                switch (toUnit.toLowerCase()) {
                    case "kilograms":
                        return value / 1000;
                    case "pounds":
                        return value / 453.592;
                    default:
                        break;
                }
                break;
            default:
                conversionLabel.setText("Invalid conversion");
                break;
        }
        return value;
    }
    
    
        
    
}