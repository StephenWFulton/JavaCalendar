/**
 *	@file Simulation.h
 * 	@author Ryan Niday
 *	@since 2016.02.27
 *
 */
#ifndef SIMULATION_H
#define SIMULATION_H

#include <iostream>
#include <string>
#include <fstream>

#include "Stack.h"
#include "Queue.h"

class Simulation{
public:
    /**
     *  @pre a valid file name within the current directory is inputed.
     *  @post Creates a usable Simulation instance.
     *  @return None.
     *
     */
    Simulation(std::string file);
    /**
     *  @pre None.
     *  @post None.
     *  @return A print out of the whole simulation.
     *
     */
    void runSimulation();
    /**
     *  @pre None.
     *  @post None.
     *  @return A Stack filled with VIP0 - VIP9 used for comparison when deciding if a VIP stays or not.
     *
     */
    void VIPList();
    /**
     *  @pre a valid string of one of the 10 VIPs is inputed.
     *  @post an accurate stack of all the VIPs currently in store.
     *  @return A print out of a VIP stays or not
     *
     */
    void VIPStack(std::string VIP);
    /**
     *  @pre a valid string of a normal customer is inputed.
     *  @post Both the Stack of VIPs and Queue of non-VIPs are accurate in comparison to who is currently in the store.
     *  @return A print out of the customer who just entered the store, including VIPs.
     *
     */
    void ListAssignments(std::string input);
    /**
     *  @pre None.
     *  @post None.
     *  @return A print out of who is currently being served, and who is waiting next.
     *
     */
    void Show();
    /**
     *  @pre None.
     *  @post The person done being served is poped or dequeued off the Stack or Queue respectively.
     *  @return A print out of who is done being served, and who is now being served.
     *
     */
    void Done();
private:
    Stack<std::string> myList;
    Stack<std::string> myStack;
    Queue<std::string> myCommandQueue;
    Queue<std::string> myQueue;
    std::string command;
    std::ifstream myFile;
};
#endif