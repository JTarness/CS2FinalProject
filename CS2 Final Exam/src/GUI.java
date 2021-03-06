import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
				h.defenseINC(2);
			}
		}
	}
	
	public static void main(String[] args) {
		launch(args);	
	}

	public void start(Stage window) {
		hero player = new hero("Player",10,3,3,3);
		goblin Jerry = new goblin("Goblin");
		skeleton bones = new skeleton("Skeleton");
		dragon Trogdor = new dragon("Dragon");
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
		
		// Tutorial Screen
		
		Label exploreControl = new Label("The goal of the game is to reach the end of the\ndungeon. To do this, you must explore and find\na key on each floor.");
		
		Label combatControl = new Label("While exploring, you may meet enemies who wish\nto end your journey. When in combat, press attack\nto attack the enemy, defend to defend yourself,\nand flee to escape.");
		
		Label rest = new Label("If you find yourself low on health, press the rest\n button and you'll feel better in no time..");
		
		Button go = new Button("Go!");
		
		VBox tutorialMenu = new VBox(30);
		tutorialMenu.setAlignment(Pos.CENTER);
		tutorialMenu.getChildren().addAll(exploreControl, combatControl,rest, go);
		Scene tutorialScene = new Scene(tutorialMenu,WIDTH, HEIGHT);
		
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
		
		// Dragon Combat Screen
		Button Attack3 = new Button("Attack");
		Button Defend3 = new Button("Defend");
		HBox combatMenu3 = new HBox(50);
		AnchorPane combat3 = new AnchorPane();
		
		combatMenu3.getChildren().addAll(Attack3, Defend3);
		AnchorPane.setTopAnchor(combatMenu3, 300.0);
		AnchorPane.setLeftAnchor(combatMenu3,200.0);
		combat3.getChildren().add(combatMenu3);
		Scene combatScene3 = new Scene(combat3);
		Label c3a = new Label(String.format("%s is attacked by a Dragon!", player.getName()));
		AnchorPane.setTopAnchor(c3a,200.0);
		AnchorPane.setLeftAnchor(c3a, 200.0);
		Label c3b = new Label("");
		AnchorPane.setTopAnchor(c3b,225.0);
		AnchorPane.setLeftAnchor(c3b, 200.0);
			
		combat3.getChildren().addAll(c3a,c3b);
		

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
				c1a.setText(String.format("%s is attacked by a Goblin!", player.getName()));
				c1b.setText("");
				Jerry.reset();
			}
		});
		
		// Floor 1 East
		
		Sword goldSword = new Sword("Gold Sword", 3, 1, 0);
		Button Floor1_Sword = new Button("Pick up the sword");
		Floor1_Sword.setMinWidth(150);
		Floor1_Sword.setMinHeight(25);
		
		Label swordLabel = new Label("There is a sword on the ground...");
		Floor1_Sword.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				player.changeEquipment(true, goldSword);
				swordLabel.setText("You picked up a gold sword!");
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
		
		Floor2_C_R.setOnAction(new EventHandler<ActionEvent>() {
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
		
		Scene Floor2_W = new Scene(Floor2_W_Anchor, WIDTH, HEIGHT);
		Floor2_C_W.setOnAction(e -> window.setScene(Floor2_W));
				
		Button Floor2_Key = new Button("Pick up the key");
		Floor2_Key.setMinWidth(150);
		Floor2_Key.setMinHeight(25);
		
		AnchorPane.setTopAnchor(Floor2_Key, 250.0);
		AnchorPane.setLeftAnchor(Floor2_Key,250.0);
		
		Label keyLabel2 = new Label("There is a key on the ground...");
		AnchorPane.setTopAnchor(keyLabel2, 200.0);
		AnchorPane.setLeftAnchor(keyLabel2,250.0);
		Floor2_Key.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				player.keysINC(1);
				keyLabel2.setText("You picked up the key!\nNow you can proceed to the final floor.");
				Floor2_Key.setVisible(false);
			}
		});
		
		Floor2_W_Anchor.getChildren().addAll(Floor2_W_E, keyLabel2, Floor2_Key);
		
		Floor2_W_E.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				if(player.getKeys() == 2) {
					Floor2_C_D.setVisible(true);
				}
				
				window.setScene(Floor2_C);
			}
		});
		
		// Floor 2 East
		Button Floor2_E_W = new Button("E");
		Floor2_E_W.setMinWidth(25);
		Floor2_E_W.setMinHeight(100);
		AnchorPane Floor2_E_Anchor = new AnchorPane();
		AnchorPane.setTopAnchor(Floor2_E_W, 175.0);
		AnchorPane.setRightAnchor(Floor2_E_W,0.0);
		Label victory2 = new Label("The skeleton has been defeated!\nYou leveled up! All stats increased by 1!");
		AnchorPane.setTopAnchor(victory2, 200.0);
		AnchorPane.setLeftAnchor(victory2,250.0);
		Floor2_E_Anchor.getChildren().addAll(Floor2_E_W, victory2);
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
		
		Floor2_S_N.setOnAction(e -> window.setScene(Floor2_C));
		
		Shield ironShield = new Shield("Iron Shield", 0, 3, 0);
		Button Floor1_Shield = new Button("Pick up the shield");
		Floor1_Shield.setMinWidth(150);
		Floor1_Shield.setMinHeight(25);
		
		Label shieldLabel = new Label("There is a shield on the ground...");
		Floor1_Shield.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				player.changeEquipment(false, ironShield);
				shieldLabel.setText("You picked up an iron shield!");
				Floor1_Shield.setVisible(false);
			}
		});
		AnchorPane.setTopAnchor(shieldLabel, 200.0);
		AnchorPane.setLeftAnchor(shieldLabel,250.0);
		AnchorPane.setTopAnchor(Floor1_Shield, 250.0);
		AnchorPane.setLeftAnchor(Floor1_Shield,250.0);
		Floor2_S_Anchor.getChildren().addAll(Floor2_S_N, shieldLabel, Floor1_Shield);
		Scene Floor2_S = new Scene(Floor2_S_Anchor, WIDTH, HEIGHT);

		Floor2_C_S.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				 window.setScene(Floor2_S);
			}
		});
		
		// Floor 3 Center
		Button Floor3_C_N = new Button("N");
		Floor3_C_N.setMinWidth(100);
		Floor3_C_N.setMinHeight(25);
		AnchorPane Floor3_C_Anchor = new AnchorPane();
		AnchorPane.setTopAnchor(Floor3_C_N, 0.0);
		AnchorPane.setLeftAnchor(Floor3_C_N,300.0);
		
		Floor3_C_N.setOnAction(e -> window.setScene(combatScene3));
		
		Label warnLabel = new Label("The air is getting warmer.\nThere are strange sounds coming from the room up ahead...");
		AnchorPane.setTopAnchor(warnLabel, 200.0);
		AnchorPane.setLeftAnchor(warnLabel,200.0);
		Floor3_C_Anchor.getChildren().addAll(Floor3_C_N, warnLabel);
		Scene Floor3_C = new Scene(Floor3_C_Anchor, WIDTH, HEIGHT);


		Floor2_C_D.setOnAction(e -> window.setScene(Floor3_C));
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
					Trogdor.reset();
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
					Floor1_Shield.setVisible(true);
					shieldLabel.setText("There is a shield on the ground...");
					Floor2_Key.setVisible(true);
					keyLabel2.setText("There is a key on the ground...");
					Floor2_C_D.setVisible(false);
					c3a.setText(String.format("%s is attacked by a Dragon!", player.getName()));
					c3b.setText("");
					}
				});
				VBox loseMenu = new VBox(20);
				loseMenu.setAlignment(Pos.CENTER);
				loseMenu.getChildren().addAll(gameOver, retry);
				Scene gameOverScene = new Scene(loseMenu,WIDTH, HEIGHT);
				
		// Win Screen
				Label win = new Label("Congraatulations!\n You have won the game!");
				Button goAgain = new Button("Play again?");
				goAgain.setPrefSize(120, 40);
				
				goAgain.setOnAction(new EventHandler<ActionEvent>(){
					@Override
					public void handle(ActionEvent event) {
					player.reset();
					Jerry.reset();
					bones.reset();
					Trogdor.reset();
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
					Floor1_Shield.setVisible(true);
					shieldLabel.setText("There is a shield on the ground...");
					Floor2_Key.setVisible(true);
					keyLabel2.setText("There is a key on the ground...");
					Floor2_C_D.setVisible(false);
					c3a.setText(String.format("%s is attacked by a Dragon!", player.getName()));
					c3b.setText("");
					}
				});
				
				VBox winMenu = new VBox(20);
				winMenu.setAlignment(Pos.CENTER);
				winMenu.getChildren().addAll(win, goAgain);
				Scene winScene = new Scene(winMenu,WIDTH, HEIGHT);

				
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
				c2a.setText(String.format("%s is attacked by a Skeleton!", player.getName()));
				c2b.setText("");
				bones.reset();
			}
		});
		
		Attack3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				combatTurn(player, Trogdor, true, false, c3a, c3b);
				if (Trogdor.hp() <= 0) {
					Trogdor.dead();
					player.levelUp();
					window.setScene(winScene);
				} else if (player.hp <= 0) {
					window.setScene(gameOverScene);
				}
			}
		});
		
		Defend3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				combatTurn(player, Trogdor, false, true, c3a, c3b);
				if (player.hp <= 0) {
					window.setScene(gameOverScene);
				}
			}
		});
		
		startButton.setOnAction(e -> window.setScene(tutorialScene));
		go.setOnAction(e -> window.setScene(tutorialScene));
		
		window.setScene(startMenu);
		window.setTitle("Dragon's Dungeon");
		window.show();	
	}	
}
