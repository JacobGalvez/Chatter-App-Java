/*
Name: Jacob Galvez
Date: 10/27/2021
Class: CS 3354.003
Professor Rick King

The class Client helps in sending your own messages to the server.
*/
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client{
    public String name;
    public ArrayList<String> msgs;
    public Chatter user;

    //Constructor -> keep in mind Chatters name!
    public Client(String name)
    {
        this.name = name;
        msgs = new ArrayList<String>();
        user = new Chatter(this);

        msgs.add(name + ": is online!\n");
    }

    public void send(String text)
    {
        msgs.add(name + ": " + text + "\n");
    }

    public boolean hasMessage()
    {
        if (msgs.size() > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String getMessage()
    {
        String s = msgs.get(0);
        msgs.remove(0);
        msgs.trimToSize();
        return s;
    }

    //help display message written
    public void display (String msg)
    {
        user.writeChat(msg);
    }
}