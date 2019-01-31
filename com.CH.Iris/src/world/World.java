package world;

import java.awt.Graphics;
import java.util.ArrayList;

import entities.Asteroid;
import entities.Entity;
import entities.EntityManager;
import entities.Power;
import entities.Repair;
import entities.SpaceShip;
import entities.Super;
import game.Game;
import game.Screen;
import runtime.Handler;

public class World {

    EntityManager entityManager;
    Handler handler;
    int count = 0;
    SpaceShip ship;
    int bottomline;
    int lineNumber;

    int nextAsteroid = 1;
    int nextPowerup = 120;

    ArrayList<Tile[]> tiles;

    public World(SpaceShip ship, Handler handler) {
        entityManager = new EntityManager();
        this.handler = handler;
        this.ship = ship;
        entityManager.add(ship);

        bottomline = 16Game.GAMESCALE20;
        lineNumber = 1;

        tiles = new ArrayList<Tile[]>();
        for(int i=-16Game.GAMESCALE10; i<=bottomline; i+=16Game.GAMESCALE) {
            Tile[] tileRow = new Tile[20];
            for(int j=0; j<tileRow.length; j++) {
                tileRow[j] = new Tile(i,-10+16Game.GAMESCALE*j,handler);
            }
            tiles.add(tileRow);
        }
    }

    public int getWidth() {
        return (int)Screen.dim.getWidth();
    }

    public int getHeight() {
        return (int)Screen.dim.getHeight();
    }
public void update() {
        entityManager.update();

        if (count % nextAsteroid == 0) {
            nextAsteroid = (int)(Math.random() * 30 + 1);
            entityManager.add(new Asteroid(handler, (int)(Math.random() * 800), ship.getYPos() - 800));
        }
        if (count % nextPowerup == 0) {
            nextPowerup = (int)(Math.random() * 240 + 120);

            switch ((int)(Math.random() * 3)) {
            case 0:
                entityManager.add(new Super(handler, (int)(Math.random() * 800), ship.getYPos() - 800));
                break;
            case 1:
                entityManager.add(new Power(handler, (int)(Math.random() * 800), ship.getYPos() - 800));
                break;
            case 2:
                entityManager.add(new Repair(handler, (int)(Math.random() * 800), ship.getYPos() - 800));
                break;
            }

        }


        count++;
        updateTiles();

    }

    public void updateTiles() {
        //System.out.println(tiles.get(tiles.size()-1)[0].y-handler.getCamera().yOffset());
        if(-handler.getCamera().yOffset()/(16Game.GAMESCALE)>=lineNumber) {
            lineNumber++;
            tiles.remove(tiles.size()-1);
            Tile[] tileRow = new Tile[20];
            for(int i=0; i<tileRow.length; i++) {
                tileRow[i] = new Tile(-10+16Game.GAMESCALEi, tiles.get(0)[0].y-16Game.GAMESCALE,handler);
            }
            tiles.add(0,tileRow);
        }
    }
public void render(Graphics g) {
        for(int i=0; i<tiles.size(); i++) {
            for(Tile t:tiles.get(i)) {
                t.render(g);
            }
        }
        entityManager.render(g);
    }

    public void addEntity(Entity e) {
        entityManager.add(e);
    }

    public void removeEntity(Entity e) {
        entityManager.remove(e);
    }

    public ArrayList<Entity> getEntities() {
        return entityManager.getEntities();
    }
}