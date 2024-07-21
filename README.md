# Chatbox

## Overview
This project implements a client-server architecture where users can host a server instance and connect with others to exchange real-time 
messages. It's designed to facilitate instant messaging between multiple clients connected to a central server.

## Features
- **Server Hosting:** Users can start a server instance on their machine.
- **Client Connectivity:** Multiple clients can connect to the server simultaneously.
- **Real-Time Messaging:** Users can send and receive messages instantly within the connected client-server network.
- **Simple Interface:** Minimalist command-line interface for ease of use and integration.

## Requirements
- **Java:** The program is written in Java and requires Java Runtime Environment (JRE) to be installed.

## Installation
1. Clone the repository to your local machine.

'''bash
git clone <repository_url>
'''

2. Compile the Java files.

'''bash
javac *.java
'''

3. Start the server.

'''bash
java ChatboxServer
'''

4. Launch clients and connect to the server.

'''bash
java ClientMain
'''

## Usage
1. Server: Run ServerMain to start the server. Specify a port number if necessary.
2. Client: Run ClientMain to launch a client instance. Enter the server's IP address and port number to connect.
3. Messaging: Once connected, clients can send messages that are relayed in real-time to all connected clients.

## Contributing
Contributions are welcome! Feel free to submit pull requests or report issues in the repository.

## License
This project is licensed under the [MIT License](https://www.mit.edu/~amini/LICENSE.md).
