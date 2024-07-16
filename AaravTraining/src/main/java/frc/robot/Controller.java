package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;

/** Add your docs here. */
public class Controller {

  private static final String MANIP_NAME = "Logitech Dual Action";
  private static final String DRIVER_NAME = "Controller (Xbox One For Windows)";
  private static final int UNKNOWN_PORT = -1;

  /* Instance variables */
  private XboxController manipulatorController;
  private XboxController driverController;
  private int manipulatorPort;
  private int driverPort;

  /* Constructor */
  public Controller() {
    manipulatorPort = getManipulatorPort();
    driverPort = getDriverPort();

    if (manipulatorPort != UNKNOWN_PORT) {
      manipulatorController = new XboxController(manipulatorPort);
    }

    if (driverPort != UNKNOWN_PORT) {
      driverController = new XboxController(driverPort);
    }
    testPrintControllerNames();
  }

  public int getManipulatorPort() {
    int portNum;
    GenericHID genericController;

    for (portNum = 0; portNum <= 5; portNum++) {
      genericController = new GenericHID(portNum);
      if (genericController.getName().equals(MANIP_NAME) == true) {
        return portNum;
      }
    }

    System.out.println("Could not find port for Manipulater Controller!");
    return UNKNOWN_PORT;
  }

  public int getDriverPort() {
    int portNum;
    GenericHID genericController;

    for (portNum = 0; portNum <= 5; portNum++) {
      genericController = new GenericHID(portNum);
      if (genericController.getName().equals(DRIVER_NAME) == true) {
        return portNum;
      }
    }

    System.out.println("Could not find port for Driver Controller!");
    return UNKNOWN_PORT;
  }

  public void updateControllers() {
    int currentManipPort = getManipulatorPort();
    int currentDriverPort = getDriverPort();

    if (currentManipPort != manipulatorPort) {
      manipulatorController = new XboxController(currentManipPort);
      manipulatorPort = currentManipPort;
      System.out.println("Manipulater port is now: " + manipulatorPort);
    }

    if (currentDriverPort != driverPort) {
      driverController = new XboxController(currentManipPort);
      driverPort = currentDriverPort;
      System.out.println("Driver port is now: " + driverPort);
    }
  }

  public void testPrintControllerNames() {
    int portNum;
    GenericHID genericController;

    for (portNum = 0; portNum < 6; portNum++) {
      genericController = new GenericHID(portNum);
      System.out.println("Port:" + portNum + "Controller Name:" + genericController.getName());
    }
  }

}