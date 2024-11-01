/*
Name: Jacob Galvez
Date: 10/27/2021
Class: CS 3354.003
Professor Rick King

The Server class helps client send to server so everyone can see their message...
 */

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server
{
    ArrayList<Client> allClients;

    private static Server instance;

    //Constructor
    public Server()
    {
        allClients = new ArrayList<Client>();
        this.instance = this;
    }

    // connects client to server needs type Client as arg
    public void connect(Client c)
    {
        allClients.add(c);
    }

    public static Server getHostServer() { return instance; }

    //runs loop to check for messages
    public void run()
    {
        while(true)
        {
            //loop allClients - check if they have messages - get messages - send messages
            if(allClients.get(0).hasMessage())
            {
                System.out.println("New Group Message!");
                broadcast(allClients.get(0).getMessage());
            }
            if(allClients.get(1).hasMessage())
            {
                System.out.println("New Group Message!");
                broadcast(allClients.get(1).getMessage());
            }
            if(allClients.get(2).hasMessage())
            {
                System.out.println("New Group Message!");
                broadcast(allClients.get(2).getMessage());
            }
            if(allClients.get(3).hasMessage())
            {
                System.out.println("New Group Message!");
                broadcast(allClients.get(3).getMessage());
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex)
            {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    //checks for new messages or if sent message.
    public void update()
    {
        if(allClients.get(0).hasMessage())
        {
            System.out.println(allClients.get(0).name + " sent a message");
            broadcast(allClients.get(0).getMessage());
        }
        if(allClients.get(1).hasMessage()){
            System.out.println(allClients.get(1).name + " sent a message");
            broadcast(allClients.get(1).getMessage());
        }
        if(allClients.get(2).hasMessage()){
            System.out.println(allClients.get(2).name +  " sent a message");
            broadcast(allClients.get(2).getMessage());
        }
        if(allClients.get(3).hasMessage()){
                    System.out.println(allClients.get(3).name + " sent a message");
                    broadcast(allClients.get(3).getMessage());
                }
    }

    // display message written to everybody
    public void broadcast(String text)
    {
        for(int i = 0; i < allClients.size(); i++)
            allClients.get(i).display(text);
    }
}