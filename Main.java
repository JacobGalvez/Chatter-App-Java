/*
Name: Jacob Galvez
Date: 10/27/2021
Class: CS 3354.003
Professor Rick King

This program simulates a group chat messenger, including graphics. This program is built for 4 users however it is not hard to add more
users if needed.
*/
class Main {
    public static void main(String[] args) {
        Server s = new Server();

        Client one = new Client("Stan");
        s.connect(one);
        Client two = new Client("Kyle");
        s.connect(two);
        Client three = new Client("Cartman");
        s.connect(three);
        Client four = new Client("Kenny");
        s.connect(four);

        s.run();
    }
}