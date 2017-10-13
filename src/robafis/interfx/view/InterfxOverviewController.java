package robafis.interfx.view;

import java.util.HashMap;
import java.util.Iterator;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import robafis.interfx.MainApp;

public class InterfxOverviewController {
	
	@FXML
	private Button boutonAvance;
	
	@FXML
	private Button boutonRecule;
	
	@FXML
	private Button boutonGauche;
	
	@FXML
	private Button boutonDroite;
	
	private MainApp mainApp;
	
	private String buttonPressedStyle = "-fx-background-color:" +
    		"	 	 linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\n" + 
    		"        linear-gradient(#020b02, #3a3a3a),\n" + 
    		"        linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),\n" + 
    		"        linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%),\n" + 
    		"        linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%); ";
	
	public InterfxOverviewController() {
	}
	
	@FXML
	private void initialize() {
		
		HashMap<Button, KeyCode> extButton = new HashMap<>();
		extButton.put(boutonAvance, KeyCode.NUMPAD8);
		extButton.put(boutonRecule, KeyCode.NUMPAD5);
		extButton.put(boutonDroite, KeyCode.NUMPAD6);
		extButton.put(boutonGauche, KeyCode.NUMPAD4);
		
		Iterator<Button> i = extButton.keySet().iterator();
		
		for(Button mapKey : extButton.keySet()) {
			
			mapKey.addEventHandler(MouseEvent.MOUSE_PRESSED, 
					new EventHandler<MouseEvent>() {
						@Override public void handle(MouseEvent e) {
							mapKey.setStyle(buttonPressedStyle);
					}
				});
			
			mapKey.addEventHandler(MouseEvent.MOUSE_RELEASED, 
				    new EventHandler<MouseEvent>() {
				        @Override public void handle(MouseEvent e) {
				            mapKey.setStyle("");
				        }
				});
			
			mapKey.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					if (event.getCode() == extButton.get(mapKey)) {
						//DO SOMETHING
					}
				}
			});
			
			mapKey.setOnKeyReleased(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					if (event.getCode() == extButton.get(mapKey)) {
						//DO SOMETHING
					}
				}
			});
		}
	}
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
	}
}
