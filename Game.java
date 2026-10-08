/* Grupa X
 * Projekat 1
 * Elvedin Grbovic 22/146  -  Konstantin Draskovic 24/157
 * FPRN:Elektrotehnika i Racunarstvo
 */

class Player{
	private String name;
    private int x, y;
    private int width, height;
    private int health;
    
    // konstruktor
    public Player(String name, int x, int y, int width, int height, int health) {
    	this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.health = health;
    }
    
    //getteri i setteri
    public String getName() {return name;}
    public void setName() {
    	if (name == null || name.isEmpty()) {
            this.name = "Unknown";
        }
    }
    
    public int getX() { return x;}
    public void setX(int x) {this.x = x;}
    
    public int getY() { return y; }
    public void setY(int y) {this.y = y;}
    
    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width;}
    
    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height;}
    
    public int getHealth() { return health; }
    public void setHealth(int health) {
        if (health < 0) this.health = 0;
        else if (health > 100) this.health = 100;
        else this.health = health;
    }
    
    //toString metoda
    @Override
    public String toString() {
        return "Player[" + name + "] @ (" + x + "," + y + ") " + width + "x" + height + " HP=" + health;
    }
    
}

class Enemy {
    private String type;
    private int x, y;
    private int width, height;
    private int damage;

    // Konstruktor
    public Enemy(String type, int x, int y, int width, int height, int damage) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.damage = damage;
    }
    

    // Getteri i setteri
    public String getType() { return type; }
    public void setType(String type) {
        if (type == null || type.isEmpty()) {
            this.type = "Unknown";
            }
        }
    
    public int getX() { return x; }
    public void setX(int x) { this.x = x;}
    
    public int getY() { return y; }
    public void setY(int y) { this.y = y;}
    
    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width;}
    
    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height;}
    
    public int getDamage() { return damage; }
    public void setDamage(int damage) {
        if (damage < 0) this.damage = 0;
        else if (damage > 100) this.damage = 100;
        else this.damage = damage;
    }
    
    

    // toString metoda
    @Override
    public String toString() {
        return "Enemy[" + type + "] @ (" + x + "," + y + ") " + width + "x" + height + " DMG=" + damage;
    }

}


public class Game {
	private Player player;
	private Enemy enemy;
	
	// Konstruktor
    public Game(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }
    
    public Player getPlayer() {return player;}
	public void setPlayer(Player player) {
		this.player = player;
	}

	public Enemy getEnemy() {return enemy;}
	public void setEnemy(Enemy enemy) {
		this.enemy = enemy;
	}

	// METODE
    public static boolean checkCollision(Player p, Enemy e) {
	    return p.getX() < e.getX() + e.getWidth() &&      
	           p.getX() + p.getWidth() > e.getX() &&      
	           p.getY() < e.getY() + e.getHeight() &&     
	           p.getY() + p.getHeight() > e.getY();
	}
    
    public void decreaseHealth() {
    	player.setHealth(player.getHealth() - enemy.getDamage());
    }
 
    public void addEnemy(Enemy e) {
    }
    
    public static String findByType() {
    	return null;
    }
    
    public static String collidingWithPlayer() {
    	return null;
    }
    
    public int resolveCollision() {
		if (checkCollision(player, enemy)) {
			decreaseHealth();
		}
		return player.getHealth();
    }
    
    
	
	public static void main(String[] args) {
		Player p1 = new Player("Darko", 0, 0, 10, 10, 100);
	    Enemy e1 = new Enemy("Goblin", 5, 5, 10, 10, 60);

	    Game igra = new Game(p1, e1);

	    int zivoti = igra.resolveCollision();
	    System.out.println("Health posle sudara: " + zivoti);
	    System.out.println(p1);
	}

}
