package com.drawingapp.main;

import com.drawingapp.module.AppModule;
import com.drawingapp.requests.SquareRequest;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceDemo {

    // This is the request
    private static final String SQUARE_REQ = "SQUARE";

    private static void sendRequest(String squareReq) {
        if(squareReq.equals(SQUARE_REQ)){

          /* Without Google guice
            DrawShape d = new DrawSquare();
          * SquareRequest request = new SquareRequest(d);
          * request.makeRequest();
          * */

            /*DrawShape d = new DrawSquare();*/
//          Using Google Guice to create this object
            /* Here we are initializing the injector, and then supply the
            instance of a class AppModule, which contains the binding that is the metadata  i.e.
            which type is bound to which concrete implementation, in the next statement we
             are asking the injector give us the Instance  of DrawShape which in the current case
             will be DrawSquare*/
            Injector injector = Guice.createInjector(new AppModule());
            // Hey Guice give me the instance of class DrawShape which can be passed
            // as an argument in the SquareRequest intsance
//            DrawShape d = injector.getInstance(DrawShape.class);

            /*SquareRequest request = new SquareRequest(d);*/
            /* Asking Guice to give us the instance of SquareRequest based on the instance of DrawShape*/
            SquareRequest request1 = injector.getInstance(SquareRequest.class);
            request1.makeRequest();

            SquareRequest request2 = injector.getInstance(SquareRequest.class);
            request2.makeRequest();

            boolean areDrawShape = request1.getDrawShape() == request2.getDrawShape();
            System.out.println("Were draw shapes equal: " + areDrawShape);

            boolean areSquareRequestEqual = request1 == request2;
            System.out.println("Were Square requests equal: " + areSquareRequestEqual);
        }

    }
    public static void main(String[] args) {
        // This method is being called with the parameter (SQUARE_REQ)
        sendRequest(SQUARE_REQ);
    }


}
