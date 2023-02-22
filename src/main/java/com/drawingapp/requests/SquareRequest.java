package com.drawingapp.requests;

import com.drawingapp.services.*;

import javax.inject.Inject;

public class SquareRequest {
    //Here the DrawShape is an interface
    DrawShape d;

    // Constructor for SquareRequest which accepts DrawShape
    // And assigns it to our instance variable d
    @Inject
    public SquareRequest(DrawShape d){
        this.d = d;

    }

    // Method that delegates the call to draw method.
    public void makeRequest(){
        d.draw();

    }

    public DrawShape getDrawShape(){
        return d;
    }
}
