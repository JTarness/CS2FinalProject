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
	public static void combatTurn(hero h, Enemy e, Boolean Attack, Boolean Defend, Label a, Label b) {
		if(h.getSpeed()>=e.speed()) {
			if(Attack == true) {
				a.setText(String.format("%s attacks the %s for %d damage!", h.getName(),e.getName(),e.hpLost(h.getAttack())));
				b.setText(String.format("%s attacks the %s for %d damage!", e.getName(),h.getName(),h.hpLost(e.attack())));
			} else {
				h.defenseINC(2);
				a.setText(String.format("%s defends!", h.getName()));
				b.setText(String.format("%s attacks the %s for %d damage!", e.getName(),h.getName(),h.hpLost(e.attack())));
			}
		}else {
			if(Attack == true) {
				a.setText(String.format("%s attacks the %s for %d damage!", e.getName(),h.getName(),h.hpLost(e.attack())));
				b.setText(String.format("%s attacks the %s for %d damage!", h.getName(),e.getName(),e.hpLost(h.getAttack())));
			} else {
				a.setText(String.format("%s attacks the %s for %d damage!", e.getName(),h.getName(),h.hpLost(e.attack())));
				b.setText(String.format("%s defends!", h.getName()));
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
		hero player = new hero("Player",10,3,3,3);
		goblin Jerry = new goblin("Goblin");
		skeleton bones = new skeleton("Skeleton");
		window.setMinHeight(HEIGHT);
		window.setMinWidth(WIDTH);
		
		// Start Screen
		Label gameTitle = new Label("Dragon's Dungeon");
		Button startButton = new Button("Start");
		startButton.setPrefSize(60, 40);
		VBox menu = new VBox(20);
		menu.setAlignment(Pos.CENTER);
		menu.getChildren().addAll(gameTitle, startButton);
		Scene startMenu = new Scene(menu, WIDTH, HEIGHT);
		
		// Goblin Combat Screen
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
		Label c1a = new Label(String.format("%s is attacked by a Goblin!", player.getName()));
		AnchorPane.setTopAnchor(c1a,200.0);
		AnchorPane.setLeftAnchor(c1a, 200.0);
		Label c1b = new Label("");
		AnchorPane.setTopAnchor(c1b,225.0);
		AnchorPane.setLeftAnchor(c1b, 200.0);
			
		combat.getChildren().addAll(c1a,c1b);
		
		// Skeleton Combat Screen
		Button Attack2 = new Button("Attack");
		Button Defend2 = new Button("Defend");
		Button Flee2 = new Button("Flee");
		HBox combatMenu2 = new HBox(50);
		AnchorPane combat2 = new AnchorPane();
		
		combatMenu2.getChildren().addAll(Attack2, Defend2, Flee2);
		AnchorPane.setTopAnchor(combatMenu2, 300.0);
		AnchorPane.setLeftAnchor(combatMenu2,200.0);
		combat2.getChildren().add(combatMenu2);
		Scene combatScene2 = new Scene(combat2);
		Label c2a = new Label(String.format("%s is attacked by a Skeleton!", player.getName()));
		AnchorPane.setTopAnchor(c2a,200.0);
		AnchorPane.setLeftAnchor(c2a, 200.0);
		Label c2b = new Label("");
		AnchorPane.setTopAnchor(c2b,225.0);
		AnchorPane.setLeftAnchor(c2b, 200.0);
			
		combat2.getChildren().addAll(c2a,c2b);
		
		
		

		// Floor 1 Center
		Button Floor1_C_S = new Button("S");
		Button Floor1_C_E = new Button("W");
		Button Floor1_C_W = new Button("E");
		Button Floor1_C_R = new Button("Rest");
		Button Floor1_C_D = new Button("Down");
		Floor1_C_D.setVisible(false);
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
		
		Floor1_C_Anchor.getChildren().addAll(Floor1_C_S,Floor1_C_E,Floor1_C_W,Floor1_C_R,Floor1_C_D, Floor1_Label);
		Scene Floor1_C = new Scene(Floor1_C_Anchor, WIDTH, HEIGHT);
		
		Floor1_C_R.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				player.heal();
			}
		});
		
		// Floor 1 West
		Button Floor1_Key = new Button("Pick up the key");
		Floor1_Key.setMinWidth(150);
		Floor1_Key.setMinHeight(25);
		
		Label keyLabel = new Label("There is a key on the ground...");
		Floor1_Key.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				player.keysINC(1);
				keyLabel.setText("You picked up the key!\nNow you can proceed to the second floor.");
				Floor1_Key.setVisible(false);
			}
		});
		AnchorPane.setTopAnchor(keyLabel, 200.0);
		AnchorPane.setLeftAnchor(keyLabel,250.0);
		AnchorPane.setTopAnchor(Floor1_Key, 250.0);
		AnchorPane.setLeftAnchor(Floor1_Key,250.0);
		
		Button Floor1_W_E = new Button("W");
		Floor1_W_E.setMinWidth(25);
		Floor1_W_E.setMinHeight(100);
		AnchorPane Floor1_W_Anchor = new AnchorPane();
		AnchorPane.setTopAnchor(Floor1_W_E, 175.0);
		AnchorPane.setLeftAnchor(Floor1_W_E,0.0);
		Floor1_W_Anchor.getChildren().addAll(Floor1_W_E, keyLabel, Floor1_Key);
		Scene Floor1_W = new Scene(Floor1_W_Anchor, WIDTH, HEIGHT);
		Floor1_C_W.setOnAction(e -> window.setScene(Floor1_W));
		
		Floor1_W_E.setOnAction(e -> window.setScene(Floor1_C));
		Floor1_W_E.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.setScene(Floor1_C);
				if(player.getKeys() > 0) {
					Floor1_C_D.setVisible(true);
				}
			}
		});
		Flee.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.setScene(Floor1_C);
			}
		});
		
		// Floor 1 East
		
		Sword ironSword = new Sword("Iron Sword", 3, 0, 0);
		Button Floor1_Sword = new Button("Pick up the sword");
		Floor1_Sword.setMinWidth(150);
		Floor1_Sword.setMinHeight(25);
		
		Label swordLabel = new Label("There is a sword on the ground...");
		Floor1_Sword.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				player.changeEquipment(true, ironSword);
				swordLabel.setText("You picked up an iron sword!");
				Floor1_Sword.setVisible(false);
			}
		});
		AnchorPane.setTopAnchor(swordLabel, 200.0);
		AnchorPane.setLeftAnchor(swordLabel,250.0);
		Button Floor1_E_W = new Button("E");
		Floor1_E_W.setMinWidth(25);
		Floor1_E_W.setMinHeight(100);
		AnchorPane Floor1_E_Anchor = new AnchorPane();
		AnchorPane.setTopAnchor(Floor1_E_W, 175.0);
		AnchorPane.setRightAnchor(Floor1_E_W,0.0);
		AnchorPane.setTopAnchor(Floor1_Sword, 250.0);
		AnchorPane.setLeftAnchor(Floor1_Sword,250.0);
		Floor1_E_Anchor.getChildren().addAll(Floor1_E_W, Floor1_Sword, swordLabel);
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
		Label victory = new Label("The goblin has been defeated!\nYou leveled up! All stats increased by 1!");
		AnchorPane.setTopAnchor(victory, 200.0);
		AnchorPane.setLeftAnchor(victory,250.0);
		Floor1_S_Anchor.getChildren().addAll(Floor1_S_N, victory);
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
		
		
		
		
		
		// Floor 2 Center
		Button Floor2_C_S = new Button("S");
		Button Floor2_C_E = new Button("W");
		Button Floor2_C_W = new Button("E");
		Button Floor2_C_R = new Button("Rest");
		Button Floor2_C_U = new Button("Up");
		Button Floor2_C_D = new Button("Down");
		Floor2_C_D.setVisible(false);
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
		Floor1_C_R.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				player.heal();
			}
		});
		
		// Floor 2 West
		Button Floor2_W_E = new Button("W");
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
		Button Floor2_E_W = new Button("E");
		Floor2_E_W.setMinWidth(25);
		Floor2_E_W.setMinHeight(100);
		AnchorPane Floor2_E_Anchor = new AnchorPane();
		AnchorPane.setTopAnchor(Floor2_E_W, 175.0);
		AnchorPane.setRightAnchor(Floor2_E_W,0.0);
		Floor2_E_Anchor.getChildren().add(Floor2_E_W);
		Scene Floor2_E = new Scene(Floor2_E_Anchor, WIDTH, HEIGHT);
		Floor2_C_E.setOnAction(e -> window.setScene(Floor2_E));
		
		Floor2_E_W.setOnAction(e -> window.setScene(Floor2_C));
		
		Floor2_C_E.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				if(bones.isAlive() == true) {
					window.setScene(combatScene2);
				}
				else {
					 window.setScene(Floor2_E);
				}
			}
		});

		
		// Floor 2 South
		Button Floor2_S_N = new Button("N");
		Floor2_S_N.setMinWidth(100);
		Floor2_S_N.setMinHeight(25);
		AnchorPane Floor2_S_Anchor = new AnchorPane();
		AnchorPane.setTopAnchor(Floor2_S_N, 0.0);
		AnchorPane.setLeftAnchor(Floor2_S_N,300.0);
		Floor2_S_Anchor.getChildren().add(Floor2_S_N);
		Scene Floor2_S = new Scene(Floor2_S_Anchor, WIDTH, HEIGHT);
		
		Floor2_C_S.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				 window.setScene(Floor2_S);
			}
		});
		
		Floor2_S_N.setOnAction(e -> window.setScene(Floor2_C));
			
		//Game Over Screen
				Label gameOver = new Label("Game Over...");
				Button retry = new Button("Retry");
				retry.setPrefSize(60, 40);
				
				retry.setOnAction(new EventHandler<ActionEvent>(){
					@Override
					public void handle(ActionEvent event) {
					player.reset();
					Jerry.reset();
					bones.reset();
					window.setScene(startMenu);
					c1a.setText(String.format("%s is attacked by a Goblin!", player.getName()));
					c1b.setText("");
					Floor1_Sword.setVisible(true);
					swordLabel.setText("There is a sword on the ground...");
					Floor1_Key.setVisible(true);
					keyLabel.setText("There is a key on the ground...");
					Floor1_C_D.setVisible(false);
					c2a.setText(String.format("%s is attacked by a Skeleton!", player.getName()));
					c2b.setText("");
					}
				});
				
				VBox menu2 = new VBox(20);
				menu2.setAlignment(Pos.CENTER);
				menu2.getChildren().addAll(gameOver, retry);
				Scene gameOverScene = new Scene(menu2,WIDTH, HEIGHT);

				
		Attack.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				combatTurn(player, Jerry, true, false, c1a, c1b);
				if (Jerry.hp() <= 0) {
					Jerry.dead();
					player.levelUp();
					window.setScene(Floor1_S);
				} else if (player.hp <= 0) {
					window.setScene(gameOverScene);
				}
			}
		});
		
		Defend.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				combatTurn(player, Jerry, false, true, c1a, c1b);
				if (player.hp <= 0) {
					window.setScene(gameOverScene);
				}
			}
		});
		
		
		Attack2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				combatTurn(player, bones, true, false, c2a, c2b);
				if (bones.hp() <= 0) {
					bones.dead();
					player.levelUp();
					window.setScene(Floor2_E);
				} else if (player.hp <= 0) {
					window.setScene(gameOverScene);
				}
			}
		});
		
		Defend2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				combatTurn(player, bones, false, true, c2a, c2b);
				if (player.hp <= 0) {
					window.setScene(gameOverScene);
				}
			}
		});
		
		Flee2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.setScene(Floor2_C);
			}
		});
		
		startButton.setOnAction(e -> window.setScene(Floor1_C));
		
		window.setScene(startMenu);
		window.setTitle("Dragon's Dungeon");
		window.show();	
	}	
}
