import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class GUI extends Application {

	final int HEIGHT = 500;
	
	final int WIDTH = 700;
	public static void combatTurn(hero h, Enemy e, Boolean Attack, Boolean Defend) {
		if(h.getSpeed()>=e.speed()) {
			if(Attack == true) {
				e.hpLost(h.getAttack());
				h.hpLost(e.attack());
			} else {
				h.defenseINC(2);
				h.hpLost(e.attack());
			}
		}else {
			if(Attack == true) {
				h.hpLost(e.attack());
				e.hpLost(h.getAttack());
			} else {
				h.hpLost(e.attack());
				h.defenseINC(2);
			}
		}
	}
	public static void attack(goblin g) {
		System.out.println("Attack!");
		g.hpLost(5);
		
	}
	
	public static void defend(hero h) {
		h.defenseINC(2);
		
		System.out.println("Defend!");
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}

	public void start(Stage window) {
		boolean Combat_G = false;
		boolean Combat_S = false;
		boolean Combat_D = false;
		hero player = new hero("player",10,3,3,3);
		window.setMinHeight(HEIGHT);
		window.setMinWidth(WIDTH);
		
		// Start Screen
		Label label1 = new Label("Game Title");
		Button button1 = new Button("Start");
		button1.setPrefSize(60, 40);
		
		// Combat Screen 1
		goblin Jerry = new goblin("Jerry");
		
		
		
		Button Attack = new Button("Attack");
		Button Defend = new Button("Defend");
		Button Flee = new Button("Flee");
		HBox combatMenu = new HBox(50);
		AnchorPane combat = new AnchorPane();
		
		
		combatMenu.getChildren().addAll(Attack, Defend, Flee);
		AnchorPane.setTopAnchor(combatMenu, 300.0);
		AnchorPane.setLeftAnchor(combatMenu,200.0);
		combat.getChildren().add(combatMenu);
		Scene combatScene = new Scene(combat);
		Label a = new Label("Ambush!");
		AnchorPane.setTopAnchor(a,0.0);
		AnchorPane.setLeftAnchor(a, 200.0);
		
		
			
			
			
			
			
			Defend.setOnAction(e -> defend(player));
			combat.getChildren().add(a);
			
		
		
		// Floor 1 Center
		Button Floor1_C_S = new Button("S");
		Button Floor1_C_E = new Button("E");
		Button Floor1_C_W = new Button("W");
		Button Floor1_C_R = new Button("Rest");
		Button Floor1_C_D = new Button("Down");
		Label Floor1_Label = new Label("Floor 1");
		
		Floor1_C_S.setMinWidth(100);
		Floor1_C_S.setMinHeight(25);
		Floor1_C_E.setMinWidth(25);
		Floor1_C_E.setMinHeight(100);
		Floor1_C_W.setMinWidth(25);
		Floor1_C_W.setMinHeight(100);
		Floor1_C_D.setMinHeight(50);
		Floor1_C_D.setMinWidth(50);
		Floor1_C_R.setMinHeight(50);
		Floor1_C_R.setMinWidth(50);
		
		AnchorPane Floor1_C_Anchor = new AnchorPane();
		AnchorPane.setBottomAnchor(Floor1_C_S, 0.0);
		AnchorPane.setLeftAnchor(Floor1_C_S,300.0);
		AnchorPane.setTopAnchor(Floor1_C_E, 175.0);
		AnchorPane.setLeftAnchor(Floor1_C_E,0.0);
		AnchorPane.setTopAnchor(Floor1_C_W, 175.0);
		AnchorPane.setRightAnchor(Floor1_C_W,0.0);
		AnchorPane.setTopAnchor(Floor1_C_D, 100.0);
		AnchorPane.setLeftAnchor(Floor1_C_D,450.0);
		AnchorPane.setTopAnchor(Floor1_C_R, 200.0);
		AnchorPane.setLeftAnchor(Floor1_C_R,330.0);
		AnchorPane.setTopAnchor(Floor1_Label, 5.0);
		AnchorPane.setLeftAnchor(Floor1_Label,5.0);
		
		Floor1_C_Anchor.getChildren().addAll(Floor1_C_S,Floor1_C_E,Floor1_C_W,Floor1_C_D,Floor1_C_R, Floor1_Label);
		Scene Floor1_C = new Scene(Floor1_C_Anchor, WIDTH, HEIGHT);
		
		Floor1_C_R.setOnAction(e -> window.setScene(combatScene));
		
		
		// Floor 1 West
		Button Floor1_W_E = new Button("E");
		Floor1_W_E.setMinWidth(25);
		Floor1_W_E.setMinHeight(100);
		AnchorPane Floor1_W_Anchor = new AnchorPane();
		AnchorPane.setTopAnchor(Floor1_W_E, 175.0);
		AnchorPane.setLeftAnchor(Floor1_W_E,0.0);
		Floor1_W_Anchor.getChildren().add(Floor1_W_E);
		Scene Floor1_W = new Scene(Floor1_W_Anchor, WIDTH, HEIGHT);
		Floor1_C_W.setOnAction(e -> window.setScene(Floor1_W));
		
		Floor1_W_E.setOnAction(e -> window.setScene(Floor1_C));
		
		
		
		// Floor 1 East
		Button Floor1_E_W = new Button("W");
		Floor1_E_W.setMinWidth(25);
		Floor1_E_W.setMinHeight(100);
		AnchorPane Floor1_E_Anchor = new AnchorPane();
		AnchorPane.setTopAnchor(Floor1_E_W, 175.0);
		AnchorPane.setRightAnchor(Floor1_E_W,0.0);
		Floor1_E_Anchor.getChildren().add(Floor1_E_W);
		Scene Floor1_E = new Scene(Floor1_E_Anchor, WIDTH, HEIGHT);
		Floor1_C_E.setOnAction(e -> window.setScene(Floor1_E));
		
		Floor1_E_W.setOnAction(e -> window.setScene(Floor1_C));
		
		// Floor 1 South
		Button Floor1_S_N = new Button("N");
		Floor1_S_N.setMinWidth(100);
		Floor1_S_N.setMinHeight(25);
		AnchorPane Floor1_S_Anchor = new AnchorPane();
		AnchorPane.setTopAnchor(Floor1_S_N, 0.0);
		AnchorPane.setLeftAnchor(Floor1_S_N,300.0);
		Floor1_S_Anchor.getChildren().add(Floor1_S_N);
		Scene Floor1_S = new Scene(Floor1_S_Anchor, WIDTH, HEIGHT);
		
		
		
		Floor1_C_S.setOnAction(e -> window.setScene(Floor1_S));
		Floor1_C_S.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				if(Jerry.isAlive() == true) {
					window.setScene(combatScene);
				}
				else {
					 window.setScene(Floor1_S);
				}
			}
		});
		
		
		
		
		Floor1_S_N.setOnAction(e -> window.setScene(Floor1_C));
		
		Attack.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				
				Jerry.hpLost(player.getAttack());
				
				if(Jerry.hp() <= 0) {
					Jerry.dead();
					window.setScene(Floor1_S);
				}
			}
		});
		
		
		
		// Floor 2 Center
		Button Floor2_C_S = new Button("S");
		Button Floor2_C_E = new Button("E");
		Button Floor2_C_W = new Button("W");
		Button Floor2_C_R = new Button("Rest");
		Button Floor2_C_U = new Button("Up");
		Button Floor2_C_D = new Button("Down");
		Label Floor2_Label = new Label("Floor 2");
		
		Floor2_C_S.setMinWidth(100);
		Floor2_C_S.setMinHeight(25);
		Floor2_C_E.setMinWidth(25);
		Floor2_C_E.setMinHeight(100);
		Floor2_C_W.setMinWidth(25);
		Floor2_C_W.setMinHeight(100);
		Floor2_C_U.setMinHeight(50);
		Floor2_C_U.setMinWidth(50);
		Floor2_C_D.setMinHeight(50);
		Floor2_C_D.setMinWidth(50);
		Floor2_C_R.setMinHeight(50);
		Floor2_C_R.setMinWidth(50);
		
		AnchorPane Floor2_C_Anchor = new AnchorPane();
		AnchorPane.setBottomAnchor(Floor2_C_S, 0.0);
		AnchorPane.setLeftAnchor(Floor2_C_S,300.0);
		AnchorPane.setTopAnchor(Floor2_C_E, 175.0);
		AnchorPane.setLeftAnchor(Floor2_C_E,0.0);
		AnchorPane.setTopAnchor(Floor2_C_W, 175.0);
		AnchorPane.setRightAnchor(Floor2_C_W,0.0);
		AnchorPane.setTopAnchor(Floor2_C_U, 100.0);
		AnchorPane.setLeftAnchor(Floor2_C_U,200.0);
		AnchorPane.setTopAnchor(Floor2_C_D, 100.0);
		AnchorPane.setLeftAnchor(Floor2_C_D,450.0);
		AnchorPane.setTopAnchor(Floor2_C_R, 200.0);
		AnchorPane.setLeftAnchor(Floor2_C_R,330.0);
		AnchorPane.setTopAnchor(Floor2_Label, 5.0);
		AnchorPane.setLeftAnchor(Floor2_Label,5.0);
		
		Floor2_C_Anchor.getChildren().addAll(Floor2_C_S,Floor2_C_E,Floor2_C_W,Floor2_C_U,Floor2_C_D,Floor2_C_R, Floor2_Label);
		Scene Floor2_C = new Scene(Floor2_C_Anchor, WIDTH, HEIGHT);
		Floor1_C_D.setOnAction(e -> window.setScene(Floor2_C));
		Floor2_C_U.setOnAction(e -> window.setScene(Floor1_C));
		
		// Floor 2 West
		Button Floor2_W_E = new Button("E");
		Floor2_W_E.setMinWidth(25);
		Floor2_W_E.setMinHeight(100);
		AnchorPane Floor2_W_Anchor = new AnchorPane();
		AnchorPane.setTopAnchor(Floor2_W_E, 175.0);
		AnchorPane.setLeftAnchor(Floor2_W_E,0.0);
		Floor2_W_Anchor.getChildren().add(Floor2_W_E);
		Scene Floor2_W = new Scene(Floor2_W_Anchor, WIDTH, HEIGHT);
		Floor2_C_W.setOnAction(e -> window.setScene(Floor2_W));
		
		Floor2_W_E.setOnAction(e -> window.setScene(Floor2_C));
		
		// Floor 2 East
		Button Floor2_E_W = new Button("W");
		Floor2_E_W.setMinWidth(25);
		Floor2_E_W.setMinHeight(100);
		AnchorPane Floor2_E_Anchor = new AnchorPane();
		AnchorPane.setTopAnchor(Floor2_E_W, 175.0);
		AnchorPane.setRightAnchor(Floor2_E_W,0.0);
		Floor2_E_Anchor.getChildren().add(Floor2_E_W);
		Scene Floor2_E = new Scene(Floor2_E_Anchor, WIDTH, HEIGHT);
		Floor2_C_E.setOnAction(e -> window.setScene(Floor2_E));
		
		Floor2_E_W.setOnAction(e -> window.setScene(Floor2_C));
		
		// Floor 2 South
		Button Floor2_S_N = new Button("N");
		Floor2_S_N.setMinWidth(100);
		Floor2_S_N.setMinHeight(25);
		AnchorPane Floor2_S_Anchor = new AnchorPane();
		AnchorPane.setTopAnchor(Floor2_S_N, 0.0);
		AnchorPane.setLeftAnchor(Floor2_S_N,300.0);
		Floor2_S_Anchor.getChildren().add(Floor2_S_N);
		Scene Floor2_S = new Scene(Floor2_S_Anchor, WIDTH, HEIGHT);
		Floor2_C_S.setOnAction(e -> window.setScene(Floor2_S));
		
		Floor2_S_N.setOnAction(e -> window.setScene(Floor2_C));
			
		VBox layout1 = new VBox(20);
		layout1.setAlignment(Pos.CENTER);
		layout1.getChildren().addAll(label1, button1);
		Scene scene1 = new Scene(layout1, WIDTH, HEIGHT);
		
		
		button1.setOnAction(e -> window.setScene(Floor1_C));
		
		window.setScene(scene1);
		window.setTitle("Title");
		window.show();	
	}
	
	
}
