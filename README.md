# DistributedSystems_Assignment1

this project designs a mobile agent framework where three main tiers are communicating
the computer tier is a client that asks servers for best route recommendations
the server node has two ports: first port acts as a server to keep listening to drivers requests
and for the second port, the server here acts as a client asking the 3rd tier which is the sensor to get the readings
the sensor tier is a server that get requests from the server and send readings back to it

To run the code:
put the three classes in the same project then run them in the order mentioned below:
sensor >> server >>computer
