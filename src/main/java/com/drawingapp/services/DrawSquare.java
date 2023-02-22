package com.drawingapp.services;

import com.drawingapp.annotations.ColorValue;
import com.drawingapp.annotations.EdgeValue;

import javax.inject.Inject;

// Concrete Implementing the interface DrawShape here.
public class DrawSquare implements DrawShape{

    // Constants
    private String color;
    private Integer edge;

    @Inject
    public DrawSquare(@ColorValue String color, @EdgeValue Integer edge) {
        super();
        this.color = color;
        this.edge = edge;
    }

    // Implement the method here,
    @Override
    public void draw(){
        System.out.println("Drawing Square of color: " + color + " and edge: " + edge);

    }

}
