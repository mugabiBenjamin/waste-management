# Waste Collection System

[![License](https://img.shields.io/badge/License-Proprietary-red.svg)](./LICENSE)
[![Java](https://img.shields.io/badge/Java-8%2B-blue.svg)](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
[![Maintenance](https://img.shields.io/badge/Maintained-yes-green.svg)](https://github.com/mugabiBenjamin/waste-management/graphs/commit-activity)
[![Issues](https://img.shields.io/github/issues/mugabiBenjamin/waste-management.svg)](https://github.com/mugabiBenjamin/waste-management/issues)

The Waste Collection System is a Java-based application designed to manage waste pickup requests, user accounts, and truck allocation. It provides a simple interface for users to schedule waste pickups, and for administrators to manage resources and track request statuses.

The system tracks:

- User accounts with authentication
- Available waste collection trucks
- Pickup requests and their status
- Automatic truck allocation based on location

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)
- [System Architecture](#system-architecture)
- [Creating Issues](#creating-issues)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)
- [Acknowledgments](#acknowledgments)

## Installation

### Prerequisites

- [Java Development Kit (JDK) 8 or higher](https://www.oracle.com/java/technologies/javase-downloads.html)
- Any Java IDE:
  - [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
  - [Eclipse](https://www.eclipse.org/downloads/)
  - [Visual Studio Code](https://code.visualstudio.com/download) with [Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)

### Setup Instructions

1. Clone the repository:

   ```bash
   git clone https://github.com/mugabiBenjamin/waste-management.git
   ```

2. Navigate to the project directory:

   ```bash
   cd waste-management
   ```

3. Compile the Java files:

   ```bash
   javac WasteCollectionSystem.java
   ```

4. Run the application:

   ```bash
   java WasteCollectionSystem
   ```

## Usage

### User Login

The system currently uses a simple username/password authentication system with predefined user accounts:

- Username: `user1`, Password: `pass1`, Location: `Location A`
- Username: `user2`, Password: `pass2`, Location: `Location B`
- Username: `user3`, Password: `pass3`, Location: `Location C`

### Making a Pickup Request

1. Log in with valid credentials
2. Select option 1 from the main menu
3. The system will automatically assign an available truck if one is in your location
4. You will receive a confirmation notification with your request status

### Testing the System

The application includes a test mode that simulates multiple pickup requests across different users and displays the resulting allocation of trucks and request statuses.

## Features

- **User Authentication**: Secure login system
- **Pickup Requests**: Users can request waste pickup from their location
- **Automatic Truck Allocation**: System intelligently assigns trucks based on availability and location
- **Status Tracking**: Both users and administrators are notified of request status changes
- **Test Simulation**: Built-in test mode to demonstrate system functionality

## System Architecture

The system consists of four main classes:

1. **User**: Stores user credentials and location
2. **Truck**: Manages truck availability and location
3. **PickupRequest**: Tracks request details, assigned truck, and status
4. **SystemManager**: Handles core operations including login, menu display, and request processing

## Creating Issues

If you encounter a bug or have a feature suggestion, please create an issue on the project's GitHub repository:

1. Go to [Issues](https://github.com/mugabiBenjamin/waste-management/issues)
2. Click on "New Issue"
3. Select the appropriate issue template if available
4. Provide a descriptive title and detailed description of the issue or feature request
5. Include steps to reproduce for bugs, or use cases for feature requests
6. Add appropriate labels, milestone, and assignee if applicable
7. Submit the issue

Please check existing issues before creating a new one to avoid duplicates.

## Contributing

We welcome contributions to the Waste Collection System project!

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/your-feature-name`
3. Commit your changes: `git commit -m 'Add some feature'`
4. Push to the branch: `git push origin feature/your-feature-name`
5. Open a pull request

### Development Roadmap

- Database integration for persistent storage
- Admin interface for truck management
- User registration functionality
- Improved UI/console interface
- Location tracking and route optimization

## License

This project is licensed under a Proprietary License with Contribution Rights - see the [LICENSE](./LICENSE) file for full details.

Key points:

- The software is owned by Benjamin Mugabi
- Contributions are welcome through official channels
- Redistribution and creating derivative works are prohibited
- Commercial use requires a separate license

## Contact

Project Maintainer: Benjamin Mugabi - [mugabiben6@gmail.com](mailto:mugabiben6@gmail.com)

Project Link: [https://github.com/mugabiBenjamin/waste-management](https://github.com/mugabiBenjamin/waste-management)

## Acknowledgments

- Thanks to everyone who has contributed to the development of this system
- Special appreciation to our beta testers who provided valuable feedback

[Back to Top](#waste-collection-system)
