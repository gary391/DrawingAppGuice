package com.drawingapp.module;

import com.drawingapp.annotations.ColorValue;
import com.drawingapp.annotations.EdgeValue;
import com.drawingapp.requests.SquareRequest;
import com.drawingapp.services.DrawShape;
import com.drawingapp.services.DrawSquare;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class AppModule extends AbstractModule {
    // Here we are tell google guice that when ever it is asked for the
    // DrawShape it needs to provide DrawSqure concreate class
    @Override
    protected void configure(){
        bind(DrawShape.class).to(DrawSquare.class).in(Scopes.SINGLETON);
//        bind(String.class).toInstance("Red"); // toString is used to bind constant i.e. String or Integer
//        bind(Integer.class).toInstance(40);
        bind(String.class).annotatedWith(ColorValue.class).toInstance("Pink");
        bind(Integer.class).annotatedWith(EdgeValue.class).toInstance(400);
        bind(SquareRequest.class).in(Scopes.SINGLETON);


    }
}
