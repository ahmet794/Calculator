package uk.ac.rhul.cs2800;

/**
 * Create a view and a model, add itself as observer to the view so that changes can be observed.
 * 
 * @author ahmet
 *
 */
// This class is inspired by Dave's many many examples, MVC-separated.
public class Controller implements ControllerInterface {

  CalcModel calculator = CalcModel.getInstance();
  ViewInterface myView = null;

  /**
   * This constructor creates a Controller object and adds itself as an observer.
   * 
   * @param view is the view that is added
   */
  public Controller(ViewInterface view) {
    addView(view);
  }

  /**
   * This constructor creates a Controller object.
   * 
   */
  public Controller() {

  }

  private void calculateAction() {
    Double value = calculator.calculate(myView.getExpression());
    myView.setAnswer(value.toString());
  }

  private void changeType(OpType type) {
    myView.setAnswer("Changed the type to " + type);
  }


  @Override
  public void addView(ViewInterface view) {
    myView = view;
    view.addCalcObserver(this::calculateAction);
    view.addTypeObserver(this::changeType);
  }

}
