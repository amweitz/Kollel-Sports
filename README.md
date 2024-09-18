# Camp Sports Scheduling Program

This project addresses a scheduling conflict problem at camp, where basketball and hockey games were often scheduled at the same time for 300+ players, leading to conflicts when a player was on multiple teams. Typically, the sports staff would spend two hours every night manually creating a schedule. This program automates the scheduling process, eliminating conflicts and generating a downloadable PDF of the final schedule, saving hours of manual work.

## Features
- **Conflict-Free Scheduling**: Automatically generates a schedule that prevents conflicts, ensuring no player is scheduled for two games in the same time slot.
- **GUI for Input**: A user-friendly interface built using JSwing allows sports staff to input team information, including player names and captains.
- **Trie Table for Player Data**: Efficiently stores and sorts teams based on their players, using a Trie data structure to optimize conflict detection and scheduling.
- **PDF Scheduler and Downloader**: Automatically generates a PDF of the final schedule and provides an option to download it directly to the user's computer.

## How It Works
1. **Input Teams**: The sports staff inputs teams, sorted by sport (basketball, hockey, etc.), through the provided GUI. Player names and captains are also input.
2. **Trie-Based Storage**: The program stores the teams in a Trie Table, organized by player names. This structure allows the system to quickly find which teams a player is associated with, ensuring no two teams with the same player are scheduled at the same time.
3. **Conflict Resolution**: The scheduling algorithm ensures that no player is double-booked during any time slot.
4. **PDF Generation**: Once the schedule is finalized, the program generates a PDF file that staff can download and print for easy reference.

## Technologies Used
- **Trie Table**: Used to efficiently store and manage teams based on players, enabling fast lookups to avoid scheduling conflicts.
- **PDF Writer**: Generates the final schedule in PDF format for easy sharing and printing.
- **JSwing**: Provides a graphical user interface (GUI) for the sports staff to easily input teams, players, and other scheduling details.

## Benefits
- **Saves Time**: Automates the scheduling process, saving sports staff hours of work each night.
- **Eliminates Conflicts**: Ensures no player is scheduled for two games in the same time slot, resolving the core issue.
- **User-Friendly**: The GUI makes it easy for staff to input data and receive a completed schedule without needing to manage complex algorithms.

## Installation
1. Download the `.jar` file provided under the [Tags](#) and [Releases](#) section. 
2. Run the `.jar` file on your machine.
3. The JSwing GUI will open for user input.

## Usage
1. Enter the teams for each sport, including player names and team captains.
2. Click to generate the schedule, and the program will automatically ensure no conflicts between teams.
3. Download the generated PDF schedule for use.

