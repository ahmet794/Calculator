package uk.ac.rhul.cs2800;

import java.util.function.Consumer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

/**
 * GUI view class.
 * 
 * @author ahmet
 *
 */
// This code is inspired by Dave's many many examples, MVC-Separated.
public class MyView implements ViewInterface {

  /**
   * Calculate button on the menu.
   * 
   */
  @FXML
  private Button calcButton;

  /**
   * Infix button to change the type of calculation.
   * 
   */
  @FXML
  private RadioButton infix;

  /**
   * Postfix button to change the type of calculation.
   * 
   */
  @FXML
  private RadioButton postfix;

  /**
   * The object that links the postfix and infix buttons.
   * 
   */
  @FXML
  private ToggleGroup type;

  /**
   * The expression that is set.
   * 
   */
  @FXML
  private TextField expressionBox;

  /**
   * The label where the answer is shown.
   * 
   */
  @FXML
  private Text answerField;

  /**
   * My name at the corner of the GUI.
   * 
   */
  @FXML
  private Text name;

  /**
   * Title Calculator in the middle.
   * 
   */
  @FXML
  private Text title;

  /**
   * Version on the side of the title.
   * 
   */
  @FXML
  private Text version;

  @Override
  public String getExpression() {
    return expressionBox.getText();
  }

  @Override
  public void setAnswer(String str) {
    answerField.setText(str);
  }

  @Override
  public void addCalcObserver(Observer runnable) {
    calcButton.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {
        runnable.notifyObservers();
      }
    });

  }

  @Override
  public void addTypeObserver(Consumer<OpType> consumer) {
    type.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

      @Override
      public void changed(ObservableValue<? extends Toggle> observable, Toggle from, Toggle to) {
        consumer.accept(to == infix ? OpType.INFIX : OpType.POSTFIX);
      }
    });
  }



}
