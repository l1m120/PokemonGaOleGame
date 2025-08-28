# 🎮 Pokémon Battle Simulator (Java OOP Project)

A **console-based game** simulating Pokémon battles, built in **Java** to demonstrate **core Object-Oriented Programming (OOP) principles** such as **encapsulation, inheritance, polymorphism, and abstraction**.  
This project was developed as part of the **Object-Oriented Programming Fundamentals** course and serves as a portfolio piece showcasing clean OOP design in practice.  

---

## ⚙️ About the Project
Players can simulate a **1v1 Pokémon battle** with turn-based mechanics, where each Pokémon has unique stats and moves. The project highlights **modular class design**, **type-specific behaviors**, and **abstracted move logic**, all implemented using Java OOP concepts.  

---

## 🔑 Key OOP Concepts Applied
- **Encapsulation** – Pokémon attributes (HP, attack, type) kept private, accessed via getters/setters to ensure data integrity  
- **Inheritance** – `Pokemon` base class with subclasses like `FirePokemon`, `WaterPokemon`, `GrassPokemon` reusing and extending functionality  
- **Polymorphism** – Generic `attack()` method behaves differently depending on Pokémon type, allowing flexible battle interactions  
- **Abstraction** – `Move` abstract class defines attack interface, with concrete moves (`Tackle`, `Flamethrower`, `WaterGun`) implementing unique logic  

---

## ✨ Features
- 🐉 **Modular Pokémon Classes** – Each Pokémon is an object with its own stats & moveset  
- ⚔️ **Turn-Based Battle System** – Real-time battle loop with console battle logs  
- 🖥 **Console UI** – Text-based interface for accessible and simple gameplay  
- 🏆 **Battle Outcome Display** – Shows final victor after the fight  

---

## 🚀 Getting Started

### Prerequisites
- Install [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html)  

### Run the Game
```bash
# 1. Clone the repository
git clone https://github.com/l1m120/PokemonGaOleGame

# 2. Navigate to the project folder
cd PokemonGaOleGame

# 3. Compile the source files
javac src/*.java

# 4. Run the game
java src.Main
