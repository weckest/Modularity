import world.World;
import world.pois.House;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI {
    JFrame frame;
    JPanel panel;
    World world;
    Camera camera;

    public GUI(World w) {
        world = w;
        frame = new JFrame("Modularity");
        panel = new JPanel();
        frame.addKeyListener(new AL());
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setFocusable(true);
        frame.setVisible(true);
    }

    public void setCamera(Camera c) {
        camera = c;
        makeNewPanel();
    }

    public void makeNewPanel() {
        panel.removeAll();
        panel.setSize(frame.getWidth(), frame.getHeight());
        panel.setLocation(0, 0);
        panel.setLayout(new GridLayout(camera.getWidth(), camera.getHeight()));

    }

    public void displaypoi(Object poi) {
        House house = (House) poi;
        char[][] floorplan = house.getFloorplan();
        panel.removeAll();
        panel.setSize(200 + floorplan.length * 10, 200 + floorplan.length * 10);
        panel.setLocation((frame.getWidth() / 2) - (panel.getWidth() / 2), (frame.getHeight() / 2) - (panel.getHeight() / 2));
        panel.setLayout(new GridLayout(floorplan.length, floorplan[0].length));

        for(int i = 0; i < floorplan.length; i++) {
            for(int j = 0; j < floorplan[i].length; j++) {
                panel.add(new JLabel(String.valueOf(floorplan[i][j])));
            }
        }
        frame.setContentPane(panel);
    }

    public void displayWorld() {
        Object[][] map = world.getWorld();
        makeNewPanel();

        int yMin = camera.positionY - (camera.height / 2);
        int yMax = camera.positionY + (camera.height / 2);
        int xMin = camera.positionX - (camera.width / 2);
        int xMax = camera.positionX + (camera.width / 2);

        for(int i = yMin; i < yMax; i++) {
            for(int j = xMin; j < xMax; j++) {
                if(map[i][j] instanceof House) {
                    JLabel label = new JLabel(map[i][j].toString());
                    label.addMouseListener(new poiListener(map[i][j]));
                    panel.add(label);
                } else {
                    panel.add(new JLabel(map[i][j].toString()));
                }
            }
            panel.add(new JLabel(" "));
        }

        frame.setContentPane(panel);
    }

    public class poiListener implements MouseListener {
        Object poi;

        public poiListener(Object poi) {
            this.poi = poi;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            displaypoi(poi);
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    public class AL implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_W) {
                if((camera.positionY - camera.getHeight()/2 - 1) >= 0) {
                    camera.moveW();
                    displayWorld();
                }
            }
            if(keyCode == KeyEvent.VK_A) {
                if((camera.positionX - camera.getWidth()/2 - 1) >= 0) {
                    camera.moveA();
                    displayWorld();
                }
            }
            if(keyCode == KeyEvent.VK_S) {
                if((camera.positionY + camera.getHeight()/2 + 1) <= world.getWorld().length) {
                camera.moveS();
                displayWorld();
                }
            }
            if(keyCode == KeyEvent.VK_D) {
                if((camera.positionX + camera.getWidth()/2 + 1) <= world.getWorld()[0].length) {
                    camera.moveD();
                    displayWorld();
                }
            }
            if(keyCode == KeyEvent.VK_ESCAPE) {
                displayWorld();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}


