/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.LittleBoat.View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author samux
 */
public class CustomButton extends JButton{
    private boolean mousePressed;
    
    public CustomButton(){
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(3,3,3,3));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mousePressed=true;
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                mousePressed = false;
            }
        });
    }

    @Override
    protected void paintComponent(Graphics graphic) {
        Graphics2D g2 =(Graphics2D)graphic.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height=getHeight();
        int size= Math.min(width, height);
        int position_X=(width-size)/2;
        int position_Y=(height-size)/2;
        if(mousePressed){
            g2.setColor(Color.LIGHT_GRAY);
        }else
            g2.setColor(Color.WHITE);
        g2.fill(new Ellipse2D.Double(position_X, position_Y, width, height));    
        g2.dispose();
        super.paintComponent(graphic);
    }
}
