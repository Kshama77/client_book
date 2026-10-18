# ClientBook

A simple Java console application to manage basic client information. Built with Java basics: classes, objects, `ArrayList`, loops, conditionals, methods, and input validation.

## Features
- Add a client (name, phone, email, company)
- View all clients
- Search clients by name or company
- Update client information
- Delete a client
- Simple menu-driven console interface

## Requirements
- Java JDK 8 or later
- No external libraries or database required

## Run
Open a terminal in the project folder and run:

```bash
javac -d out src/com/clientbook/*.java
java -cp out com.clientbook.Main
```

On Windows, the same commands work in Command Prompt or PowerShell if Java is installed.

## Project structure
```text
ClientBook/
├── src/
│   └── com/
│       └── clientbook/
│           ├── Client.java
│           └── Main.java
├── .gitignore
└── README.md
```

## Notes
Data is stored in memory while the program runs. Closing the application clears the client list.
